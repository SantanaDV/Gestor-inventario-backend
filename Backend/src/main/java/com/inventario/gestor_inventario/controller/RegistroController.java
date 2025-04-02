package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    // Endpoint público para registro
    @PostMapping
    public Usuario CrearUsuario(@RequestBody Usuario usuario) {
        if(usuario.getRol() == null || usuario.getRol() == "ROLE_EMPLEADO"){
            usuario.setRol("empleado");
        }
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        Date tiempo = new Date();
        usuario.setFechaAlta(tiempo);
        return this.usuarioController.CrearActualizarUsuario(usuario);
    }
}
