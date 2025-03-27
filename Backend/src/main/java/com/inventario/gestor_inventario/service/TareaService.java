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
     * Listamos las tareas
     * @param tarea recibe una tarea
     * @return tarea
     */
    Tarea ListarTarea(Tarea tarea);

    /**
     * Crear tarea
     * @param tarea recibe una tarea
     * @return crear
     */
    Tarea CrearTarea(Tarea tarea);


    /**
     * Elimino tarea
     * @param tarea recibe la tarea que va a ser eliminada
     */
    void EliminarTarea(int id);
}
