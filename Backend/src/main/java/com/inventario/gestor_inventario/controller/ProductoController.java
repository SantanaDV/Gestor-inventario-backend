package com.inventario.gestor_inventario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.gestor_inventario.entities.Estanteria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.EstanteriaServiceImpl;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import com.inventario.gestor_inventario.utilities.AsignarProductosDTO;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private ProductoServiceImpl productoServiceImpl;
    private EstanteriaServiceImpl estanteriaServiceImpl;
    private final Logger log = LoggerFactory.getLogger(ProductoController.class);

    public ProductoController(ProductoServiceImpl productoServiceImpl, EstanteriaServiceImpl estanteriaServiceImpl) {
        this.productoServiceImpl = productoServiceImpl;
        this.estanteriaServiceImpl = estanteriaServiceImpl;
    }

    @GetMapping
    public List<Producto> listaProductos() {
        return productoServiceImpl.listaProductos();
    }


    @GetMapping("/productosContados")
    public Integer totalProductosContados() {
        return productoServiceImpl.totalProductosContados();
    }

    @GetMapping("/conExistencias")
    public Integer listarConExistencias() {
        return productoServiceImpl.listarConExistencias();

    }

    @GetMapping("/conFaltantes")
    public Integer listarConFaltantes() {
        return productoServiceImpl.listarConFaltantes();
    }


    @GetMapping("/obtenerProductoQR/{codigo_qr}")
    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    public Producto obtenerProductoPorQR(@PathVariable String codigo_qr) {
        return productoServiceImpl.obtenerProductoConQR(codigo_qr);
    }


    @PostMapping(consumes = "multipart/form-data")
    public Producto CrearProducto(
            @RequestPart("producto") String productoJSON,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ProductoCatDTO producto = objectMapper.readValue(productoJSON, ProductoCatDTO.class);
        if (producto.getFecha_creacion() == null) {
            producto.setFecha_creacion(new Timestamp(System.currentTimeMillis()));

        }

        Dotenv dotenv = Dotenv.configure()
                .directory("src/main/resources")
                .filename("variables.env")
                .load();
        String urlServer = dotenv.get("URL_SERVER");
        String port = dotenv.get("PORT_SERVER");
        String protocol = dotenv.get("SERVER_PROTOCOL");

        if (imagen != null && !imagen.isEmpty()) {
            Path uploadDir = Paths.get("src/main/resources/static/uploads/");
            Files.createDirectories(uploadDir);

            String filename = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            Path path = uploadDir.resolve(filename);
            Files.copy(imagen.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            producto.setUrl_img(filename);
        }
        return this.productoServiceImpl.CrearActualizarProducto(producto);
    }


    @PutMapping(consumes = "multipart/form-data")
    public Producto ActualizarProducto(
            @RequestPart("producto") String productoJSON,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ProductoCatDTO producto = objectMapper.readValue(productoJSON, ProductoCatDTO.class);
        // Verificamos si la imagen es nula o vacía
        if (imagen != null && !imagen.isEmpty()) {
            // Si se pasa una imagen nueva, la actualizamos
            Path uploadDir = Paths.get("src/main/resources/static/uploads/");
            Files.createDirectories(uploadDir);

            String filename = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            Path path = uploadDir.resolve(filename);
            Files.copy(imagen.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            // Actualizamos la URL de la imagen
            producto.setUrl_img(filename);
        }
        // Si no se pasa una imagen, se deja la imagen original que ya tenía el producto
        return this.productoServiceImpl.CrearActualizarProducto(producto);
    }


    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {
        Producto producto = productoServiceImpl.listaProductos().stream()
                .filter(p -> p.getId_producto() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
        productoServiceImpl.EliminarProducto(producto);
    }

    /**
     * Asignar varios productos a una misma estantería.
     * Recibe un JSON con { id_estanteria, ids_producto: [ ... ] }.
     */
    @PutMapping("/asignarEstanteria")
    public ResponseEntity<Void> asignarProductosAEstanteria(
            @RequestBody AsignarProductosDTO dto) {

        log.debug(" asignarEstanteria recibí DTO = {}", dto);

        // Recupera el posible id_estanteria (puede ser null al desasignar)
        Integer idEst  = dto.getId_estanteria();
        Map<Integer,Integer> baldas = dto.getBaldas();

        for (Integer idProd : dto.getIds_producto()) {
            Optional<Producto> opt = productoServiceImpl.obtenerPorId(idProd);
            if (opt.isEmpty()) {
                log.warn("⚠ Producto id={} no existe, lo ignoro", idProd);
                continue;
            }
            Producto p = opt.get();

            // 1) Si idEst es null, quitar la estantería; si no, cargarla
            Estanteria e = (idEst != null)
                    ? estanteriaServiceImpl.getEstanteriaByEstanteriaId(idEst)
                    : null;
            p.setEstanteria(e);

            // 2) Asignar la balda (puede venir null también)
            Integer b = (baldas != null ? baldas.get(idProd) : null);
            log.debug("   producto id={} → balda del mapa = {}", idProd, b);
            p.setBalda(b);

            // 3) Persistir cambios
            productoServiceImpl.save(p);
            log.debug("   >> producto {} guardado con estanteria={} balda={}", idProd, e, b);
        }

        return ResponseEntity.ok().build();
    }
        /**
         *  Editar únicamente la balda de un producto
         */
        @PatchMapping("/{id}/balda")
        public ResponseEntity<Producto> editarBalda(
                @PathVariable int id,
                @RequestBody Map<String, Integer> body
        ) {
            return productoServiceImpl.obtenerPorId(id)
                    .map(p -> {
                        Integer nuevaBalda = body.get("balda");
                        p.setBalda(nuevaBalda);
                        Producto guardado = productoServiceImpl.save(p);
                        return ResponseEntity.ok(guardado);
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        /**
         *  Desasignar producto de estantería (quita estantería y balda)
         */
        @DeleteMapping("/{id}/desasignar")
        public ResponseEntity<Void> desasignarProducto(@PathVariable int id) {
            return productoServiceImpl.obtenerPorId(id)
                    .map(p -> {
                        p.setEstanteria(null);
                        p.setBalda(null);
                        productoServiceImpl.save(p);
                        return ResponseEntity.noContent().<Void>build();
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }




}
