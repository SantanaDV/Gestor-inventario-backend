package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.service.implementations.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tareasWeb")
public class TareaWebController {

    @Autowired
    private TareaServiceImpl tareaService;

    @GetMapping
    public String listarTareas(Model model) {
        // Obtener el número de tareas dependeiendo de su estado
        List<Tarea> tareasEnProcesoPorHacer = tareaService.contarTareasEnProcesoPorHacer();
        List<Tarea> tareasFinalizadasHoy = tareaService.contarTareasFinalizadas();

        // Agregar los valores al modelo para pasarlos a la vista
        model.addAttribute("tareasProHaz", tareasEnProcesoPorHacer);
        model.addAttribute("tareasFinalizadasHoy", tareasFinalizadasHoy);

        model.addAttribute("listarTareas",tareaService.ListarTarea());

        return "tareas";
    }
}

