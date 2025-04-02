package com.inventario.gestor_inventario.security;

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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter,
                                                   JwtValidationFilter jwtValidationFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas (acceso sin autenticación)

                        // Cualquier otra ruta requiere autenticación
                        .requestMatchers("/login", "/registro").permitAll()
                        .requestMatchers("/api/usuario/admin").hasRole("ADMIN")
                        .requestMatchers("/api/usuario/**").hasAnyRole("ADMIN", "EMPLEADO")
                        .requestMatchers("/api/usuario/empleado").hasRole("EMPLEADO")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jwtValidationFilter, JwtAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new JwtAuthenticationFilter(authenticationManager);
    }

    @Bean
    public JwtValidationFilter jwtValidationFilter(AuthenticationManager authenticationManager) {
        return new JwtValidationFilter(authenticationManager);
    }
}

//@Configuration
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    // Constructor para inyectar el UserDetailsService
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    // Configuración principal de seguridad
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http,
//                                                   JwtAuthenticationFilter jwtAuthenticationFilter,
//                                                   JwtValidationFilter jwtValidationFilter) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Deshabilita la protección CSRF
//                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura la política de sesión como STATELESS
//                .authorizeHttpRequests(auth -> auth
//                        // Rutas públicas (acceso sin autenticación)
//                        .requestMatchers("/login").permitAll() // Permitir acceso al endpoint de login
//                        .requestMatchers("/registro").permitAll() // Permitir acceso al endpoint de registro
////                        .requestMatchers("/api/usuario/listar").permitAll()
//
//                        // Cualquier otra ruta requiere autenticación
//                        .anyRequest().authenticated()
//                )
//                .addFilter(jwtAuthenticationFilter) // Añade el filtro de autenticación JWT
//                .addFilterAfter(jwtValidationFilter, JwtAuthenticationFilter.class); // Añade el filtro de validación JWT después del filtro de autenticación
//
//        return http.build(); // Construye y devuelve la configuración de seguridad
//    }
//
//
//    // Configura el proveedor de autenticación
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService); // ya es UserDetailsService
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//
//    // Configura el AuthenticationManager
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
//            throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    // Configura el codificador de contraseñas (BCrypt)
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Declara el filtro de autenticación JWT como un bean
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        return new JwtAuthenticationFilter(authenticationManager);
//    }
//
//    // Declara el filtro de validación JWT como un bean
//    @Bean
//    public JwtValidationFilter jwtValidationFilter(AuthenticationManager authenticationManager) {
//        return new JwtValidationFilter(authenticationManager);
//    }
//}
