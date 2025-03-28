package com.inventario.gestor_inventario.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexWebController {

    @GetMapping
    public String returnIndex(Model model) {
        return "index";
    }
}