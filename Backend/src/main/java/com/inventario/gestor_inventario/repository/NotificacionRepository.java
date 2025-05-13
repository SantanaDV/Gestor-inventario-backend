package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion,Integer> {


}
