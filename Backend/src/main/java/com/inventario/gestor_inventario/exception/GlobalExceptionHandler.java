package com.inventario.gestor_inventario.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

/**
 * Manejador global de excepciones.
 * Captura las excepciones lanzadas en los controladores y devuelve respuestas uniformes.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Captura y maneja las excepciones de tipo CustomException.
     *
     * @param ex Excepción lanzada en el sistema.
     * @return Respuesta con el mensaje de error y un código 400 BAD REQUEST.
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> manejarCustomException(CustomException ex) {
            ErrorResponse error = new ErrorResponse(
                    ex.getMessage(),
                    HttpStatus.BAD_REQUEST.value(),
                    LocalDateTime.now()
            );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Captura y maneja cualquier otra excepción no controlada.
     *
     * @param ex Excepción lanzada en el sistema.
     * @return Respuesta con un mensaje genérico de error interno y código 500 INTERNAL SERVER ERROR.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarExcepcionGeneral(Exception ex) {
        // Logging the exception with more detail
        org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class)
                .error("Error no controlado: ", ex);

        ErrorResponse error = new ErrorResponse(
                "Ocurrió un error inesperado. Detalles: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

    /**
     * Maneja los intentos de acceso a recursos protegidos sin los permisos adecuados.
     * Se activa cuando un usuario autenticado intenta acceder a un recurso para el cual no tiene permisos.
     *
     * @param ex Excepción capturada de tipo AccessDeniedException.
     * @return Respuesta HTTP con estado 403 Forbidden y un mensaje personalizado.
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> manejarAccesoDenegado(AccessDeniedException ex) {
        ErrorResponse error = new ErrorResponse(
                "Acceso denegado: No tienes permisos para realizar esta acción.",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    /**
     * Maneja los intentos de acceso sin autenticación.
     * Se activa cuando un usuario no autenticado intenta acceder a un recurso que requiere autenticación.
     *
     * @param ex Excepción capturada de tipo AuthenticationException.
     * @return Respuesta HTTP con estado 401 Unauthorized y un mensaje personalizado.
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> manejarAutenticacion(AuthenticationException ex) {
        ErrorResponse error = new ErrorResponse(
                "No estás autenticado. Por favor, inicia sesión.",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> manejarArgumentoInvalido(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(
                "Parámetro inválido: " + ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> manejarEntidadNoEncontrada(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "El recurso solicitado no existe.",
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


}