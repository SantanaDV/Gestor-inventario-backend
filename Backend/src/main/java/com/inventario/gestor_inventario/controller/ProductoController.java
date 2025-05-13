package com.inventario.gestor_inventario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import io.github.cdimascio.dotenv.Dotenv;
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

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private ProductoServiceImpl productoServiceImpl;

    public ProductoController(ProductoServiceImpl productoServiceImpl) {
        this.productoServiceImpl = productoServiceImpl;
    }

    @GetMapping
    public List<Producto> listaProductos(){
        return productoServiceImpl.listaProductos();
    }


    @GetMapping ("/productosContados")
    public Integer totalProductosContados(){
        return productoServiceImpl.totalProductosContados();
    }

    @GetMapping("/conExistencias")
    public Integer listarConExistencias(){
        return  productoServiceImpl.listarConExistencias();

    }

    @GetMapping("/conFaltantes")
    public Integer listarConFaltantes(){
        return  productoServiceImpl.listarConFaltantes();}

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable int id) {
        return productoServiceImpl.listaProductos().stream()
                .filter(p -> p.getId_producto() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
    }

    @GetMapping("/obtenerProductoQR/{codigo_qr}")
    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    public Producto obtenerProductoPorQR(@PathVariable String codigo_qr){
        return productoServiceImpl.obtenerProductoConQR(codigo_qr);
    }

    @PostMapping(consumes = "multipart/form-data")
    public Producto CrearProducto(
            @RequestPart("producto") String productoJSON,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ProductoCatDTO producto = objectMapper.readValue(productoJSON, ProductoCatDTO.class);
        if(producto.getFecha_creacion() == null){
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
}
