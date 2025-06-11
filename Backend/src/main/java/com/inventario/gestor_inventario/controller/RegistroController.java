package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    private UsuarioServiceImpl usuarioController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegistroController(UsuarioServiceImpl usuario){
        this.usuarioController = usuario;
    }
    /**
     * Endpoint público para registro de nuevos usuarios.
     * – Si no hay un ADMIN autenticado o el rol enviado no es "admin", se fuerza "empleado".
     * – Sólo un ADMIN puede crear otro ADMIN.
     */

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        //  Comprobamos si quien hace la petición tiene ROLE_ADMIN
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean esAdminAutenticado = auth != null
                && auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        //  Si el cliente pidió rol "admin" y además es admin quien registra → mantenemos admin
        if (esAdminAutenticado && "admin".equalsIgnoreCase(usuario.getRol())) {
            usuario.setRol("admin");
        } else {
            // En cualquier otro caso (registro público o rol distinto) → empleado
            usuario.setRol("empleado");
        }

        // Encriptar contraseña
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));

        //  Fecha de alta y estado por defecto
        usuario.setFechaAlta(new Date());
        usuario.setEstado(1);

        // 5) Guardar y devolver
        return usuarioController.CrearActualizarUsuario(usuario);
    }
}
