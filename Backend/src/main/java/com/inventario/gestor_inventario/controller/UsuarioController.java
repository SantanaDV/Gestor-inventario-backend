package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.repository.UsuarioRepository;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UsuarioController {

    private UsuarioServiceImpl usuarioController;

    public UsuarioController(UsuarioServiceImpl usuario){
        this.usuarioController = usuario;
    }

    @GetMapping
    public List<Usuario> ListarUsuarios() {
        return usuarioController.ListarUsuarios();
    }

    @PostMapping
    public Usuario CrearUsuario(@RequestBody Usuario usuario) {
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
