package com.inventario.gestor_inventario.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImagenController {

    @GetMapping("/imagen/{nombreImagen}")
    public ResponseEntity<Resource> obtenerImagen(@PathVariable String nombreImagen) throws IOException {
        // Ruta de la imagen en el directorio 'static/img'
        Resource resource = new ClassPathResource("static/uploads/" + nombreImagen);

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        String contentType = "image/jpeg";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(resource);
    }
}
