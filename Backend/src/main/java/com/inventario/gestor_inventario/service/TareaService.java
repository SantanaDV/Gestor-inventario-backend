package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Pedido;
import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.utilities.TareaCategoriaDTO;

import java.util.List;

public interface TareaService {
    /**
     * Lista de tareas
     * @return List<Tarea>
     */
    List<TareaCategoriaDTO> ListarTarea();



    /**
     * Crear tarea
     * @param tarea recibe una tarea
     * @return crear
     */
    Tarea CrearTarea(TareaCategoriaDTO tarea);


    /**
     * Elimino tarea
     * @param id recibe el id de la tarea que va a ser eliminada
     */
    void EliminarTarea(int id);

    /**
     * Cuenta el total de tareas en Proceso
     * @return long
     */
    List<Tarea> contarTareasEnProcesoPorHacer();


    /**
     * Cuenta el total de tareas Finalizadas
     * @return long
     */
    List<Tarea> contarTareasFinalizadas();



}
