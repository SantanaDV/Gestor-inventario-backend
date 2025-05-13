package com.inventario.gestor_inventario.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.inventario.gestor_inventario.security.TokenJwtConfig.*;

@Component
public class JwtValidationFilter extends BasicAuthenticationFilter {
    // Constructor que recibe un AuthenticationManager y lo pasa al constructor de la clase padre
    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {
        // Obtenemos el encabezado de autorización de la solicitud
        String header = request.getHeader(HEADER_AUTHORIZATION);

        // Verificamos si el encabezado es nulo o no comienza con el prefijo del token
        if (header == null || !header.startsWith(PREFIX_TOKEN)) {
            chain.doFilter(request, response);
            return;
        }
        // Extraemos el token eliminando el prefijo y los espacios en blanco
        String token = header.replace(PREFIX_TOKEN, "").trim();
        try {
            // Parseamos el token JWT y verificamos su firma usando la clave secreta
            // Usando parserBuilder() de la versión 0.12.6 de JJWT
            Jws<Claims> jwsClaims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);

            // Obtenemos los claims (datos) del token
            Claims claims = jwsClaims.getBody();
            // Extraemos el nombre de usuario (subject) del token
            String username = claims.getSubject();

            // Extraer la lista de roles desde los claims
            List<String> roles = claims.get("authorities", List.class);
            String rol = claims.get("rol", String.class); // Extraer el rol del token

            // Verificamos si el nombre de usuario o los roles son nulos
            if (username == null || roles == null) {
                // Si son nulos, devolvemos un error de no autorizado
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }

            // Convertir roles a a una colección GrantedAuthority
            Collection<GrantedAuthority> authorities = roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            // Creamos un objeto de autenticación con el nombre de usuario y los roles
            // Autenticamos el usuario con los roles obtenidos
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            auth.setDetails(rol); // Establecer el rol como detalle de la autenticación

            // Establecemos la autenticación en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(auth);
            // Continuamos con la cadena de filtros
            chain.doFilter(request, response);

        } catch (JwtException e) {
            // Si ocurre una excepción al validar el token, devolvemos un error de no autorizado
            Map<String, String> body = Map.of(
                    "error", e.getMessage(),
                    "message", "El token JWT no es válido"
            );
            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(CONTENT_TYPE);
        }
    }
}
