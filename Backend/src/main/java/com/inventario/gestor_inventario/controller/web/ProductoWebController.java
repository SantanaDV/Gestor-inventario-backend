package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productosWeb")
//Si queremos restringir el acceso por Roles
// @PreAuthorize("hasRole('ADMIN')")

public class ProductoWebController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public String listarProductos(Model model) {
        // Obtener el número de productos dependiendo del stock
        long totalStock = productoService.totalCantidadStock();
        List<Producto> stockBajo = productoService.totalProductosStockBajo();
        List<Producto> stockCritico = productoService.totalProductosStockCritico();

        // Agregar los valores al modelo para pasarlos a la vista
        model.addAttribute("totalStock", totalStock);
        model.addAttribute("stockBajo", stockBajo);
        model.addAttribute("stockCritico", stockCritico);
        model.addAttribute("listarProductos", productoService.listaProductos());

        return "productos";
    }


}
