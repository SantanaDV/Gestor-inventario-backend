package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    /**
     *  Query en JPA que cuenta el total de tareas 'En Proceso'
     * @return long
     */
    @Query("SELECT t FROM Tarea t WHERE t.estado = 'En Proceso' OR t.estado = 'Por hacer' ")
    List<Tarea> contarTareasEnProcesoPorHacer();




    /**
     *  Query en JPA que cuenta el total de tareas 'Finalizada'
     * @return long
     */
    @Query("SELECT COUNT(t) FROM Tarea t WHERE t.estado = 'Finalizada'")
    long contarNumeroTareasFinalizadasHoy();
//    @Query("SELECT COUNT(t) FROM Tarea t WHERE t.estado = 'Finalizada'")
//    long contarNumeroTareasFinalizadas();
}
