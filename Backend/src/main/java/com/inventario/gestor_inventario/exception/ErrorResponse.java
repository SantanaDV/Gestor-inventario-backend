package com.inventario.gestor_inventario.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Clase generica que encapsula los errores con una misma estructira
 */

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String mensaje;
    private int codigo;
    private LocalDateTime timestamp;

}
