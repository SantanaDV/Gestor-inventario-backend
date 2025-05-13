package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Notificacion;
import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.service.implementations.NotificacionServiceImpl;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import com.inventario.gestor_inventario.utilities.NotificacionesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/notificacion")

public class NotificacionController {

    private NotificacionServiceImpl notificacionRepositorio;
    @Autowired
    private UsuarioServiceImpl usuarioRepositorio;

    public NotificacionController(NotificacionServiceImpl notificacion) {
        this.notificacionRepositorio = notificacion;
    }

    @GetMapping
    public List<NotificacionesDTO> ListarNotificaciones( ) {
        return notificacionRepositorio.ListarNotificaciones();
    }

    @PostMapping
    public Notificacion CrearNotificacion(@RequestBody NotificacionesDTO notificacion) {
        return this.notificacionRepositorio.CrearActualizarNotificacion(notificacion);
    }

    @PutMapping
    public Notificacion ActualizarNotificacion(@RequestBody NotificacionesDTO notificacion) {
        return this.notificacionRepositorio.CrearActualizarNotificacion(notificacion);
    }

    @DeleteMapping("/{id}")
    public void DeleteNotificacion(@PathVariable int id) {
        this.notificacionRepositorio.EliminarNotificacion(id);
    }


}
