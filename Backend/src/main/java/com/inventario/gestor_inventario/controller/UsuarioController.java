package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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



    // Endpoint protegido para administradores de prueba
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Bienvenido, administrador!";
    }

    // Endpoint protegido para empleados de prueba
    @GetMapping("/empleado")
    @PreAuthorize("hasRole('EMPLEADO') and hasRole('ADMIN')")
    public String empleado() {
        return "Bienvenido, empleado!";
    }

    // Endpoint protegido para usuarios administrador (listar usuarios)
    @GetMapping("/admin/listarUsuarios")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> ListarUsuarios() {
        return usuarioController.ListarUsuarios();
    }

    // Endpoint protegido para administradores (actualizar usuario)
    @PutMapping ("/admin/actualizarUsuario")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario ActualizarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioController.CrearActualizarUsuario(usuario);
    }

    // Endpoint protegido para administradores (eliminar usuario)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarUsuario(@PathVariable int id) {
        this.usuarioController.EliminarUsuario(id);}

    // Nuevo endpoint para empleados (solo pueden ver su propio perfil)
    @GetMapping("/empleado/miPerfil")
    @PreAuthorize("hasRole('EMPLEADO')")
    public String miPerfil(@RequestParam String email) {
        return usuarioController.obtenerUsuarioPorEmail(email);
    }


}
