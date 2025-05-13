package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Otros métodos de la lógica de negocio para Usuario (crear, actualizar, eliminar, etc.)

    /**
     * Carga un usuario por su email, mapeando sus roles a GrantedAuthority.
     * Se asume que en la base de datos, el campo email es único y actúa como username.
     * El campo 'estado' se usa para determinar si el usuario está habilitado (por ejemplo, 1 = activo).
     * El campo 'roles' es un conjunto de roles (por ejemplo, "ADMIN" o "EMPLEADO").
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar el usuario por su email
        Optional<Usuario> userOptional = Optional.ofNullable(usuarioRepository.findByEmail(email));
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format("El usuario %s no existe en el sistema", email));
        }
        Usuario user = userOptional.get();

        // Convertir el rol del usuario a GrantedAuthority
        Set<GrantedAuthority> authorities = new HashSet<>();
        String rol = user.getRol(); // Obtener el rol como String
        if (rol != null && !rol.isEmpty()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.toUpperCase())); // Añadir prefijo "ROLE_"
        }

        // Determinar si el usuario está habilitado; se asume que 'estado' == 1 es activo
        boolean enabled = user.getEstado() == 1;

        // Crear y retornar el UserDetails con los datos del usuario
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),         // username
                user.getContrasena(),    // password (almacenada encriptada)
                enabled,                 // enabled
                true,                    // accountNonExpired
                true,                    // credentialsNonExpired
                true,                    // accountNonLocked
                authorities              // roles
        );
    }

}


