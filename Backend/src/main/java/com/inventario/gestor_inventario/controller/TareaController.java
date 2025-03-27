package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.repository.TareaRepository;
import com.inventario.gestor_inventario.service.implementations.TareaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tarea")
public class TareaController {

    private TareaServiceImpl repository;

    public TareaController(TareaServiceImpl tarea) {
        this.repository = tarea;
    }

    @GetMapping
    public List<Tarea> ListarTarea() {
        return this.repository.ListarTarea();
    }

    @PostMapping
    public Tarea CrearTarea(@RequestBody Tarea tarea) {
        return this.repository.CrearTarea(tarea);
    }

    @PutMapping
    public Tarea ActualizarTarea(@RequestBody Tarea tarea) {
        return this.repository.CrearTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void EliminarTarea(@PathVariable int id) {
        this.repository.EliminarTarea(id);
    }

}
