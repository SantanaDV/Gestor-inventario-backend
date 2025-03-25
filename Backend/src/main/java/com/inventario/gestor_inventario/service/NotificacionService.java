package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Notificacion;

import java.util.List;

public interface NotificacionService {

    /**
     * Lista las notificaciones
     * @return List<Notificaciones>
     */
    List<Notificacion> ListarNotificaciones();

    /**
     * Crear notificaciones
     * @param notificacion recibe una notificacion como parametro de entrada
     * @return Notificacion retorna los datos de la notificacion creada
     */
    Notificacion CrearActualizarNotificacion(Notificacion notificacion);



    /**
     * elimino notificacion
     * @param id recibe una notificacion como parametro de entrada
     */
    void EliminarNotificacion(int id );



}
