package com.inventario.gestor_inventario.security;

import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    // Constructor para inyectar el UserDetailsService
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Configuración principal de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter,
                                                   JwtValidationFilter jwtValidationFilter) throws Exception {
        http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable()) // Deshabilita la protección CSRF
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura la política de sesión como STATELESS
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas (acceso sin autenticación)
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/login").permitAll() // Permitir acceso al endpoint de login
                        .requestMatchers("/registro").permitAll() // Permitir acceso al endpoint de registro
                        .requestMatchers("/tareasWeb").permitAll()
                        .requestMatchers("/productosWeb").permitAll()
                        // Cualquier otra ruta requiere autenticación
                )
                .addFilter(jwtAuthenticationFilter) // Añade el filtro de autenticación JWT
                .addFilterAfter(jwtValidationFilter, JwtAuthenticationFilter.class); // Añade el filtro de validación JWT después del filtro de autenticación

        return http.build(); // Construye y devuelve la configuración de seguridad
    }


    // Configura el proveedor de autenticación
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); // ya es UserDetailsService
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // Configura el AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    // Configura el codificador de contraseñas (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Declara el filtro de autenticación JWT como un bean
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new JwtAuthenticationFilter(authenticationManager);
    }

    // Declara el filtro de validación JWT como un bean
    @Bean
    public JwtValidationFilter jwtValidationFilter(AuthenticationManager authenticationManager) {
        return new JwtValidationFilter(authenticationManager);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // En lugar de un único origen, permitimos cualquiera:
        //configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        // usa esto:
        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }




}
