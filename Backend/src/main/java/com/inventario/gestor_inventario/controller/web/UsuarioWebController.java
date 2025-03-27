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
@RequestMapping("/usuarioWeb")  // Esto sería la ruta base
public class UsuarioWebController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public String listarUsersWeb(Model model) {
        model.addAttribute("listaUsuariosWeb", usuarioService.ListarUsuarios());
        return "index";
    }
}