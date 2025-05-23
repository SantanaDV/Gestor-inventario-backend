package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioServiceImpl usuario){
        this.usuarioServiceImpl = usuario;
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

        return usuarioServiceImpl.ListarUsuarios();
    }

    // Endpoint protegido para administradores (actualizar usuario)
    @PutMapping ("/admin/actualizarUsuario")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario ActualizarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioServiceImpl.CrearActualizarUsuario(usuario);
    }

    // Endpoint protegido para administradores (eliminar usuario)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarUsuario(@PathVariable int id) {
        this.usuarioServiceImpl.EliminarUsuario(id);}

    // Nuevo endpoint para empleados (solo pueden ver su propio perfil)
    @GetMapping("/empleado/miPerfil")
    @PreAuthorize("hasRole('EMPLEADO')")
    public String miPerfil(@RequestParam String email) {
        return usuarioServiceImpl.obtenerUsuarioPorEmail(email);
    }

    @GetMapping("/existe-email")
    public ResponseEntity<Boolean> existeEmail(@RequestParam String email) {
        boolean existe = usuarioServiceImpl.ExisteUsuario(email);
        return ResponseEntity.ok(existe);
    }

    // Nuevo endpoint para sacar el nombre del usuario
    @GetMapping("/perfil")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<Usuario> obtenerPerfil(@RequestParam String email) {
        Usuario usuario = usuarioServiceImpl.buscarUsuarioPorEmail(email);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Nuevo endpoint para modificar solo el nombre del usuario
    @PutMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<Usuario> modificarNombreUsuario(
            @RequestParam String email, @RequestBody Map<String, String> requestBody) {

        String nuevoNombre = requestBody.get("nombre");

        if (nuevoNombre == null || nuevoNombre.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Si no hay "nombre", respondemos con un error 400
        }

        // Validamos si el usuario existe antes de intentar actualizar su nombre
        Usuario usuarioExistente = usuarioServiceImpl.buscarUsuarioPorEmail(email);
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build(); // Si no se encuentra, retornamos un error 404
        }

        // Actualizamos solo el nombre del usuario
        usuarioExistente.setNombre(nuevoNombre);

        // Solo actualizamos, no creamos un nuevo usuario
        Usuario usuarioActualizado = usuarioServiceImpl.actualizarUsuario(usuarioExistente);

        // Retornamos el usuario actualizado
        return ResponseEntity.ok(usuarioActualizado);
    }
    @GetMapping("/usuariosActivos")
    public Integer listarUsuariosActivos() {
        return usuarioServiceImpl.listarUsuariosActivos();
    }
<<<<<<< Updated upstream
=======
    @GetMapping("/usuario/usuariosActivos")
    public List<Usuario>listaTotal_usuarios(){return usuarioServiceImpl.ListarUsuariosActivos();}
>>>>>>> Stashed changes


}

