package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.service.implementations.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UsuarioWebController {

    @Autowired
    @Qualifier("usuarioServiceImpl")
    private UsuarioServiceImpl usuarioService;

    @RequestMapping("/api/usuarioWeb")
    public String list(Model model) {
        model.addAttribute("listaUsuarios",usuarioService.ListarUsuarios());
        return "index";
    }

}
