package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.service.implementations.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String returnIndex(Model model) {
        return "index1";
    }
}