package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.entities.Tarea;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import com.inventario.gestor_inventario.service.implementations.TareaServiceImpl;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movimientosWeb")
public class MovimientosController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public String listarProductosRecientess(Model model) {
        List<ProductosSalEntDTO> entrantes = productoService.listarProductosEntrantesRecientes();
        List<ProductosSalEntDTO> salientes = productoService.listarProductosSalientesRecientes();
        model.addAttribute("productosEntrantes", entrantes);
        model.addAttribute("productosSalientes", salientes);
        return "movimientos";
    }


}
