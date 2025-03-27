package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Notificacion;
import com.inventario.gestor_inventario.utilities.NotificacionesDTO;

import java.util.List;

public interface NotificacionService {

    /**
     * Lista las notificaciones
     * @return List<Notificaciones>
     */
    List<NotificacionesDTO> ListarNotificaciones();

    /**
     * Crear notificaciones
     * @param notificacion recibe una notificacion como parametro de entrada
     * @return Notificacion retorna los datos de la notificacion creada
     */
    Notificacion CrearActualizarNotificacion(NotificacionesDTO notificacion);



    /**
     * elimino notificacion
     * @param id recibe una notificacion como parametro de entrada
     */
    void EliminarNotificacion(int id );



}
