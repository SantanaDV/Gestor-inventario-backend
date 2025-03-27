package com.inventario.gestor_inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
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
>>>>>>> b4d5592508785c4c22c3439c802a6da2dbb0eaf5

@Controller
public class HomeController {

    @GetMapping(value="/home")
    public String home() {
        return "index";  // JSP sin la extensión .jsp
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> rama_manuel
>>>>>>> b4d5592508785c4c22c3439c802a6da2dbb0eaf5
