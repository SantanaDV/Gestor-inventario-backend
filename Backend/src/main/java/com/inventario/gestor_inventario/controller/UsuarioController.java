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




    // Endpoint protegido para administradores
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin() {
        return "Bienvenido, administrador!";
    }

    // Endpoint protegido para empleados (solo empleados, no administradores)
    @GetMapping("/empleado")
    @PreAuthorize("hasRole('EMPLEADO')")



    public String empleado() {
        return "Bienvenido, empleado!";
    }

    // Endpoint protegido para usuarios administrador (listar usuarios)

    @GetMapping("/listar")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Usuario> ListarUsuarios() {
        return usuarioController.ListarUsuarios();
    }

    // Endpoint protegido para administradores (actualizar usuario)
    @PutMapping ("/actualizar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario ActualizarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioController.CrearActualizarUsuario(usuario);
    }

    // Endpoint protegido para administradores (eliminar usuario)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void eliminarUsuario(@PathVariable int id) {
        this.usuarioController.EliminarUsuario(id);}

    // Nuevo endpoint para empleados (solo pueden ver su propio perfil)
    @GetMapping("/empleado/miPerfil/{email}")
    @PreAuthorize("hasRole('ROL_EMPLEADO')")
    public Usuario miPerfil(@PathVariable String email) {
        return usuarioController.obtenerUsuarioPorEmail(email);
    }

    @GetMapping("/contarUsuarios")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROL_EMPLEADO')")
    public Integer contarUsuarios(){
        return usuarioController.contarUsuarios();
    }
}
