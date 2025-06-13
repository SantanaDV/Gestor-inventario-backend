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
    @Query("SELECT t.estado FROM Tarea t WHERE t.estado = 'En Proceso' OR t.estado = 'Por hacer' ")
    List<Tarea> contarTareasEnProcesoPorHacer();




    /**
     *  Query en JPA que cuenta el total de tareas 'Finalizada'
     * @return long
     */
    @Query(value = "SELECT t.* FROM Tarea t WHERE t.estado = 'Finalizada' AND DATE(t.fecha_finalizacion) = CURRENT_DATE", nativeQuery = true)
    List<Tarea> contarNumeroTareasFinalizadasHoy();
//    @Query("SELECT COUNT(t) FROM Tarea t WHERE t.estado = 'Finalizada'")
//    long contarNumeroTareasFinalizadas();


//    @Query("SELECT COUNT(t) FROM estado t WHERE t.estado = 'En Proceso' OR t.estado = 'Por hacer'")
//    long contarNumeroTareasEnProceso();

    @Query("SELECT t FROM Tarea t WHERE t.estado = 'Finalizada'")
    List<Tarea>listarTareaFinalizada();

    @Query("SELECT t FROM Tarea t WHERE t.estado = 'En Proceso'")
    List<Tarea>listarTareaProceso();


    @Query("SELECT t FROM Tarea t WHERE t.estado = 'Por hacer'")
    List<Tarea> listarTareaHacer();
}
