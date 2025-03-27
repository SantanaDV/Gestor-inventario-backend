package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Otros métodos de la lógica de negocio para Usuario (crear, actualizar, eliminar, etc.)

    /**
     * Carga un usuario por su email, mapeando su rol a GrantedAuthority.
     * Se asume que en la base de datos, el campo email es único y actúa como username.
     * El campo 'estado' se usa para determinar si el usuario está habilitado (por ejemplo, 1 = activo).
     * El campo 'rol' se mapea a ROLE_ADMIN o ROLE_EMPLEADO según corresponda.
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> userOptional = Optional.ofNullable(usuarioRepository.findByMail(email));
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format("El usuario %s no existe en el sistema", email));
        }
        Usuario user = userOptional.get();

        // Convertir el valor del rol a una GrantedAuthority.
        // Se asume que el campo 'rol' es un enum con valores 'admin' o 'empleado'.
        String rol = user.getRol(); // Ejemplo: "admin" o "empleado"
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + rol.toUpperCase());
        List<GrantedAuthority> authorities = List.of(authority);

        // Determinar si el usuario está habilitado; se asume que 'estado' == 1 es activo.
        boolean enabled = user.getEstado() == 1;

        // Se asumen true para accountNonExpired, credentialsNonExpired y accountNonLocked.
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),         // username
                user.getContraseña(),    // password (almacenada encriptada)
                enabled,                 // enabled
                true,                    // accountNonExpired
                true,                    // credentialsNonExpired
                true,                    // accountNonLocked
                authorities              // roles
        );
    }
}
