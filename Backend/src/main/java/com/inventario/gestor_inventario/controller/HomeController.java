package com.inventario.gestor_inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
=======

@Controller
public class HomeController {

    @GetMapping(value="/home")
    public String home() {
        return "index";  // JSP sin la extensión .jsp
    }
}
>>>>>>> rama_manuel
