package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.service.implementations.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tareasWeb")
public class TareaWebController {

    @Autowired
    private TareaServiceImpl tareaService;

    @GetMapping
    public String listarTareas(Model model) {
        // Obtener el número de tareas dependeiendo de su estado
        long tareasEnProceso = tareaService.contarTareasEnProceso();
        long tareasPorHacer = tareaService.contarTareasPorHacer();
        long tareasFinalizadasHoy = tareaService.contarTareasFinalizadas();

        // Agregar los valores al modelo para pasarlos a la vista
        model.addAttribute("tareasEnProceso", tareasEnProceso);
        model.addAttribute("tareasPorHacer", tareasPorHacer);
        model.addAttribute("tareasFinalizadasHoy", tareasFinalizadasHoy);


        return "tareas";
    }
}

