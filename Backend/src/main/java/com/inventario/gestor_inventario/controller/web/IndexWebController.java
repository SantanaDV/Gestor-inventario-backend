package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import com.inventario.gestor_inventario.utilities.ProductoMesDTO;
import com.inventario.gestor_inventario.utilities.ProductosCantCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class IndexWebController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public String returnIndex(Model model) {
        Map<String,Long> mapa = retornarMapa1();
        model.addAttribute("mapaDatos", mapa);
        retornarMapa2(model);
        return "index";
    }


    private Map<String,Long> retornarMapa1(){
        List<ProductosCantCat>listarProductosCatDTO = productoService.listarProductosCategorias();
        Map<String,Long> mapa = new HashMap<>();
        for (ProductosCantCat producto : listarProductosCatDTO)
            mapa.put(producto.getDescripcion(), producto.getCantidad());
        return mapa;
    }
    private void retornarMapa2(Model model){
        List<ProductoMesDTO> listarProductosMes = productoService.listarProductosMes();

        List<BigInteger> cantidades = new ArrayList<>();
        List<String> meses = new ArrayList<>();
        List<String> descripciones = new ArrayList<>();

        for (ProductoMesDTO producto : listarProductosMes) {
            cantidades.add(producto.getTotalCantidad());
            meses.add(producto.getMes());
            descripciones.add(producto.getDescripcion());
        }

        model.addAttribute("cantidades", cantidades);
        model.addAttribute("meses", meses);
        model.addAttribute("descripciones", descripciones);
    }

}