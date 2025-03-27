package com.inventario.gestor_inventario.controller;
import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private UsuarioServiceImpl usuarioController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioServiceImpl usuario){
        this.usuarioController = usuario;
    }

    @GetMapping
    public List<Usuario> ListarUsuarios() {
        return usuarioController.ListarUsuarios();
    }

    @PostMapping
    public Usuario CrearUsuario(@RequestBody Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        Date tiempo = new Date();
        usuario.setFechaAlta(tiempo);
        return this.usuarioController.CrearActualizarUsuario(usuario);
    }

    @PutMapping
    public Usuario ActualizarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioController.CrearActualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        this.usuarioController.EliminarUsuario(id);
    }


}
