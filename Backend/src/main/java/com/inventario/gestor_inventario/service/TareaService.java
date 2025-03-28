package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Pedido;
import com.inventario.gestor_inventario.entities.Tarea;
import java.util.List;

public interface TareaService {
    /**
     * Lista de tareas
     * @return List<Tarea>
     */
    List<Tarea> ListarTarea();



    /**
     * Crear tarea
     * @param tarea recibe una tarea
     * @return crear
     */
    Tarea CrearTarea(Tarea tarea);


    /**
     * Elimino tarea
     * @param id recibe el id de la tarea que va a ser eliminada
     */
    void EliminarTarea(int id);

    /**
     * Cuenta el total de tareas en Proceso
     * @return long
     */
    long contarTareasEnProceso();

    /**
     * Cuenta el total de tareas Por hacer
     * @return long
     */
    long contarTareasPorHacer();


    /**
     * Cuenta el total de tareas Finalizadas
     * @return long
     */
    long contarTareasFinalizadas();



}
