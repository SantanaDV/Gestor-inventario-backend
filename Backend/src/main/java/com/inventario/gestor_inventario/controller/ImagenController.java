package com.inventario.gestor_inventario.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

@RestController
public class ImagenController {

    private static final Logger logger = LoggerFactory.getLogger(ImagenController.class);

    @GetMapping("/imagen/{nombreImagen}")
    public ResponseEntity<Resource> obtenerImagen(@PathVariable String nombreImagen) {
        logger.info("Solicitando imagen: {}", nombreImagen);
        File archivo = new File("src/main/resources/static/uploads/" + nombreImagen);

        if (!archivo.exists()) {
            logger.warn("Imagen no encontrada: {}", archivo.getAbsolutePath());
            return ResponseEntity.notFound().build();
        }

        Resource resource = new FileSystemResource(archivo);
        String contentType = "image/jpeg"; // Aquí podrías usar Files.probeContentType

        logger.info("Imagen encontrada en: {}", archivo.getAbsolutePath());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(resource);
    }

}
