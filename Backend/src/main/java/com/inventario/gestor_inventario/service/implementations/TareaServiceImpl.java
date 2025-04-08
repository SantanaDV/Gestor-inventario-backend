package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.CategoriaTarea;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.repository.CategoriasTareasRepository;
import com.inventario.gestor_inventario.repository.TareaRepository;
import com.inventario.gestor_inventario.service.TareaService;
import com.inventario.gestor_inventario.utilities.TareaCategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private CategoriasTareasRepository categoriatarea;

    @Override
    public List<Tarea> ListarTarea() {
        return tareaRepository.findAll();
    }


    @Override
    public Tarea CrearTarea(TareaCategoriaDTO tarea) {
        Tarea t1 = new Tarea();
        t1.setId(tarea.getId());
        t1.setEstado(tarea.getEstado());
        t1.setDescripcion(tarea.getDescripcion());
        t1.setFecha_asignacion(tarea.getFecha_asignacion());
        t1.setFecha_finalizacion(tarea.getFecha_finalizacion());
        t1.setEmpleado_asignado(tarea.getEmpleado_asignado());
        t1.setCategoria(categoriatarea.findById(tarea.getId_categoria()).orElse(null));
        return tareaRepository.save(t1);
    }

    @Override
    public void EliminarTarea(int id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public List<Tarea> contarTareasEnProcesoPorHacer() {
        return tareaRepository.contarTareasEnProcesoPorHacer();
    }

    @Override
    public List<Tarea> contarTareasFinalizadas() {
        return tareaRepository.contarNumeroTareasFinalizadasHoy();
    }


}
