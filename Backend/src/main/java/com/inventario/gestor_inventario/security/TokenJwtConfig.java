package com.inventario.gestor_inventario.security;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

public class TokenJwtConfig {

    // Generamos una clave secreta para firmar el token
    // Esta clave se utiliza para garantizar la integridad y autenticidad del token.
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    // Prefijo que se utiliza en el encabezado de autorización para indicar que el token es de tipo Bearer.
    // Ejemplo: "Bearer <token>"
    public static final String PREFIX_TOKEN = "Bearer ";
    // Nombre del encabezado HTTP que contiene el token JWT.
    public static final String HEADER_AUTHORIZATION = "Authorization";
    // Tipo de contenido (Content-Type) que se utiliza en las respuestas HTTP.
    public static final String CONTENT_TYPE = "application/json";
}