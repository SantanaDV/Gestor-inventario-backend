package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.repository.TareaRepository;
import com.inventario.gestor_inventario.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository tareaRepository;


    @Override
    public List<Tarea> ListarTarea() {
        return tareaRepository.findAll();
    }


    @Override
    public Tarea CrearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
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
