package com.inventario.gestor_inventario.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TokenJwtConfig {

    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 86400000; // 24 horas

    // Método para generar el JWT
    public static String generateToken(UserDetails userDetails, String userRole) {
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()); // Convertimos los roles en Strings

        return Jwts.builder()
                .setSubject(userDetails.getUsername()) // Guardamos el nombre de usuario
                .claim("authorities", roles) // Guardamos los roles
                .claim("rol", userRole) // Guardamos el rol principal
                .setIssuedAt(new Date()) // Fecha de creación
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expira en 24 horas
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // Firmamos con la clave secreta
                .compact();
    }
}


//public class TokenJwtConfig {
//
//    // Generamos una clave secreta para firmar el token
//    // Esta clave se utiliza para garantizar la integridad y autenticidad del token.
//    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
//    // Prefijo que se utiliza en el encabezado de autorización para indicar que el token es de tipo Bearer.
//    // Ejemplo: "Bearer <token>"
//    public static final String PREFIX_TOKEN = "Bearer ";
//    // Nombre del encabezado HTTP que contiene el token JWT.
//    public static final String HEADER_AUTHORIZATION = "Authorization";
//    // Tipo de contenido (Content-Type) que se utiliza en las respuestas HTTP.
//    public static final String CONTENT_TYPE = "application/json";
//}