package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Notificacion;
import com.inventario.gestor_inventario.repository.NotificacionRepository;
import com.inventario.gestor_inventario.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;


    @Override
    public List<Notificacion> ListarNotificaciones() {
        return notificacionRepository.findAll();
    }

    @Override
    public Notificacion CrearActualizarNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public void EliminarNotificacion(int  id) {
    notificacionRepository.deleteById(id);
    }
}
