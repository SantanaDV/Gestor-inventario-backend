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

    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {
        String header = request.getHeader(HEADER_AUTHORIZATION);

        if (header == null || !header.startsWith(PREFIX_TOKEN)) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace(PREFIX_TOKEN, "").trim();
        try {
            Jws<Claims> jwsClaims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);

            Claims claims = jwsClaims.getBody();
            String username = claims.getSubject();
            List<String> roles = claims.get("authorities", List.class);
            String rol = claims.get("rol", String.class); // Extraer el rol principal

            if (username == null || roles == null) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("No autorizado: Token inválido.");
                return;
            }

            // Convertir la lista de roles en autoridades Spring Security
            Collection<GrantedAuthority> authorities = roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            // Crear el token de autenticación
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            auth.setDetails(rol); // Guardar el rol en detalles

            // Configurar la autenticación en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(auth);
            chain.doFilter(request, response);

        } catch (JwtException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(CONTENT_TYPE);
            Map<String, String> body = Map.of(
                    "error", "Token no válido",
                    "message", e.getMessage()
            );
            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        }
    }
}
