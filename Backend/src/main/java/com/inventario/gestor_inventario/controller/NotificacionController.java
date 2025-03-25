package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.entities.Notificacion;
import com.inventario.gestor_inventario.service.implementations.NotificacionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacion")

public class NotificacionController {

    private NotificacionServiceImpl notificacion;

    public NotificacionController(NotificacionServiceImpl notificacion) {
        this.notificacion = notificacion;
    }

    @GetMapping
    public List<Notificacion> ListarNotificaciones( ) {
        return notificacion.ListarNotificaciones();
    }

    @PostMapping
    public Notificacion CrearNotificacion(@RequestBody Notificacion notificacion) {
        return this.notificacion.CrearActualizarNotificacion(notificacion);
    }

    @PutMapping
    public Notificacion ActualizarNotificacion(@RequestBody Notificacion notificacion) {
        return this.notificacion.CrearActualizarNotificacion(notificacion);
    }

    @DeleteMapping("/{id}")
    public void DeleteNotificacion(@PathVariable int id) {
        this.notificacion.EliminarNotificacion(id);
    }


}
