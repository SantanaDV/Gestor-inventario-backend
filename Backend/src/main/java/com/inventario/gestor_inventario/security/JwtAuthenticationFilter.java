package com.inventario.gestor_inventario.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventario.gestor_inventario.entities.Usuario;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.inventario.gestor_inventario.security.TokenJwtConfig.*;

@Component
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // Constructor que recibe el AuthenticationManager y configura la URL de login
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        // Configuramos la URL de login
        super.setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
    }

    // Método que intenta autenticar al usuario
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {
        Usuario user;
        try {
            // Lee las credenciales del usuario desde el cuerpo de la solicitud
            user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
        } catch (IOException e) {
            throw new AuthenticationServiceException("Error leyendo credenciales", e);
        }
        // Crea un token de autenticación con el email y la contraseña del usuario
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getContraseña());
        // Autentica al usuario utilizando el AuthenticationManager
        return authenticationManager.authenticate(authToken);
    }

    // Método que se ejecuta cuando la autenticación es exitosa
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult)
            throws IOException, ServletException {
        // Obtiene los detalles del usuario autenticado
        org.springframework.security.core.userdetails.User userDetails =
                (org.springframework.security.core.userdetails.User) authResult.getPrincipal();

        String username = userDetails.getUsername();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

        // Crea un mapa de claims para incluir en el token JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("authorities", roles.stream()
                .map(GrantedAuthority::getAuthority) // Obtiene el nombre del rol (por ejemplo, "ROLE_ADMIN")
                .collect(Collectors.toList())); // Convierte los roles a una lista

        // Genera el token JWT con los claims, expiración y firma
        String token = Jwts.builder()
                .setSubject(username) // Establece el sujeto del token (username)
                .addClaims(claims) // Añade los claims (roles y username)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora de expiración
                .signWith(SECRET_KEY) // Firma el token con la clave secreta
                .compact();

        // Añade el token al encabezado de la respuesta
        response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);

        // Crea un cuerpo de respuesta con el token, el nombre de usuario y un mensaje de éxito
        Map<String, String> body = new HashMap<>();
        body.put("token", token);
        body.put("username", username);
        body.put("mensaje", "Has iniciado sesión con éxito!");

        // Escribe el cuerpo de la respuesta en formato JSON
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType(CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    // Método que se ejecuta cuando la autenticación falla
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed)
            throws IOException, ServletException {
        // Crea un cuerpo de respuesta con un mensaje de error
        Map<String, String> body = new HashMap<>();
        body.put("message", "Error en la autenticación, usuario o password incorrectos!");
        body.put("error", failed.getMessage());

        // Escribe el cuerpo de la respuesta en formato JSON
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(CONTENT_TYPE);
    }
}
