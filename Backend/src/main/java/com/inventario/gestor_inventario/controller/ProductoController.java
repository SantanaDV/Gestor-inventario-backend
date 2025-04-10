package com.inventario.gestor_inventario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.gestor_inventario.entities.Pedido;
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
import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private ProductoServiceImpl productoServiceImpl;

    public ProductoController(ProductoServiceImpl productoServiceImpl) {
        this.productoServiceImpl = productoServiceImpl;
    }

    @GetMapping("/api/producto")
    public List<Producto> ListarProducto(){
        return this.productoServiceImpl.listarProductos();
    }

//    @GetMapping("/obtenerProductoQR/{codigo_qr}")
//    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
//    public List<Producto> obtenerProductoConExistencias(){
//        return productoServiceImpl.listarProductosConStock();
//    }
//    @GetMapping("/productosConExistencias")
//    public List<Producto> obtenerProductosConExistencias() {
//        return productoServiceImpl.listarProductosConStock();
//    }

    @PostMapping(consumes = "multipart/form-data")
    public Producto CrearProducto(
            @RequestPart("producto") String productoJSON,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ProductoCatDTO producto = objectMapper.readValue(productoJSON, ProductoCatDTO.class);

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

//            producto.setUrl_img(protocol+"://" + urlServer + ":" + port + "/imagen/" + filename);
        }

        return this.productoServiceImpl.CrearActualizarProducto(producto);
    }

    @PutMapping
    public Producto ActualizarProducto(@RequestBody ProductoCatDTO producto) {
        return this.productoServiceImpl.CrearActualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {
        this.eliminarProducto(id);
    }



}
