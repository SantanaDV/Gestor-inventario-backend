package com.inventario.gestor_inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping(value="/home")
    public String home() {
        return "index";  // JSP sin la extensión .jsp
    }
}