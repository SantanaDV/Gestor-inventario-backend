package com.inventario.gestor_inventario.controller.web;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class IndexWebController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public String returnIndex(Model model) {
        List<Producto> productos = Arrays.asList(
                new Producto(1, "Lector RFID UHF", 50, "activo", "QR1234567890",
                        "https://empresa.com/img/lector_rfid_uhf.jpg", new Date(), "nfc12345", new Categoria(1, "Electrónica")),
                new Producto(2, "Impresora Térmica", 30, "activo", "QR0987654321",
                        "https://empresa.com/img/impresora_termica.jpg", new Date(), "nfc54321", new Categoria(2, "Oficina"))
        );

        Map<Integer, Producto> mapaProductos = productos.stream()
                .collect(Collectors.toMap(Producto::getId_producto, producto -> producto));



        return "index";
    }
}