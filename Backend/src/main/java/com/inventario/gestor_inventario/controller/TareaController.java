package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.repository.TareaRepository;
import com.inventario.gestor_inventario.service.implementations.TareaServiceImpl;
import com.inventario.gestor_inventario.utilities.TareaCategoriaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    private static final Logger logger = LoggerFactory.getLogger(TareaController.class);

    private TareaServiceImpl repository;

    public TareaController(TareaServiceImpl tarea) {
        this.repository = tarea;
    }

    @GetMapping
    public List<TareaCategoriaDTO> ListarTarea() {
       return this.repository.ListarTarea();
    }
    @PostMapping
    public Tarea CrearTarea(@RequestBody TareaCategoriaDTO tarea) {
        return this.repository.CrearTarea(tarea);
    }

    @PutMapping
    public Tarea ActualizarTarea(@RequestBody TareaCategoriaDTO tarea) {
        return this.repository.CrearTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void EliminarTarea(@PathVariable int id) {
        this.repository.EliminarTarea(id);
    }

}
