package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Notificacion;
import com.inventario.gestor_inventario.repository.NotificacionRepository;
import com.inventario.gestor_inventario.repository.UsuarioRepository;
import com.inventario.gestor_inventario.service.NotificacionService;
import com.inventario.gestor_inventario.utilities.NotificacionesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private UsuarioRepository usuarioController;


    @Override
    public List<NotificacionesDTO> ListarNotificaciones() {
        List<Notificacion> notificacion = notificacionRepository.findAll();
        List<NotificacionesDTO> notificacioness = notificacion.stream()
                .map(n -> new NotificacionesDTO(
                        n.getId(),
                        n.getUsuario().getId_usuario(),
                        n.getEstado(),
                        n.getFecha_creacion(),
                        n.getMensaje(),
                        n.getTipo()
                ))
                .collect(Collectors.toList());
        return notificacioness;
    }

    @Override
    public Notificacion CrearActualizarNotificacion(NotificacionesDTO notificacionDTO) {
        Notificacion notificacion = new Notificacion();
        notificacion.setId(notificacionDTO.getId());
        notificacion.setUsuario(usuarioController.findById(notificacionDTO.getUsuario_id()).orElse(null));
        notificacion.setEstado(notificacionDTO.getEstado());
        notificacion.setFecha_creacion(notificacionDTO.getFecha_creacion());
        notificacion.setMensaje(notificacionDTO.getMensaje());
        notificacion.setTipo(notificacionDTO.getTipo());
        return notificacionRepository.save(notificacion);
    }

    @Override
    public void EliminarNotificacion(int  id) {
        notificacionRepository.deleteById(id);
    }
}
