package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productosWeb")
public class ProductoWebController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public String listarProductos(Model model) {
        // Obtener el número de productos dependiendo del stock
        long totalStock = productoService.totalCantidadStock();
        long stockBajo = productoService.totalProductosStockBajo();
        long stockCritico = productoService.totalProductosStockCritico();

        // Agregar los valores al modelo para pasarlos a la vista
        model.addAttribute("totalStock", totalStock);
        model.addAttribute("stockBajo", stockBajo);
        model.addAttribute("stockCritico", stockCritico);
        model.addAttribute("listarProductos", productoService.listarProductos());

        return "productos";
    }
}
