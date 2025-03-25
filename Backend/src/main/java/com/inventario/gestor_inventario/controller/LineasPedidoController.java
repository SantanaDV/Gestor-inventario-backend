package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.service.implementations.LineasPedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lineaspedido")
public class LineasPedidoController {
    private LineasPedidoServiceImpl lineasPedidoController;

    public LineasPedidoController(LineasPedidoServiceImpl lineasPedido) {
        this.lineasPedidoController = lineasPedido;
    }

    @GetMapping
    public List<LineasPedido> ListarPedidos( ) {
        return lineasPedidoController.ListarPedidos();
    }

    @PostMapping
    public LineasPedido CrearPedido(@RequestBody LineasPedido lineasPedido) {
        return this.lineasPedidoController.CrearActualizarPedido(lineasPedido);
    }

    @PutMapping
    public LineasPedido ActualizarPedido(@RequestBody LineasPedido lineasPedido) {
        return this.lineasPedidoController.CrearActualizarPedido(lineasPedido);
    }

    @DeleteMapping("/{id}")
    public void DeletePedido(@PathVariable  int id) {
        this.lineasPedidoController.EliminarPedido(id);
    }



}
