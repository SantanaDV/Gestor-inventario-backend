package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import com.inventario.gestor_inventario.utilities.ProductosCantCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class IndexWebController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public String returnIndex(Model model) {
        List<ProductosCantCat>listarProductosCatDTO = productoService.listarProductosCategorias();
        Map<String,Long> mapa = new HashMap<>();
        for (ProductosCantCat producto : listarProductosCatDTO)
            mapa.put(producto.getDescripcion(), producto.getCantidad());
        model.addAttribute("mapaDatos", mapa);
        return "index";
    }
}