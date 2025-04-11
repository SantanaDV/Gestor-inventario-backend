package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.service.implementations.LineasPedidoServiceImpl;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lineaspedido")
public class LineasPedidoController {
    private LineasPedidoServiceImpl lineasPedidoController;


    LineasPedidoController(LineasPedidoServiceImpl lineasPedido) {
        this.lineasPedidoController = lineasPedido;
    }

    @GetMapping
    public List<LineasPedidoDTO> ListarPedidos() {
        return lineasPedidoController.ListarPedidos();
    }

    @PostMapping
    public LineasPedido CrearPedido(@RequestBody LineasPedidoDTO lineasPedidoDTO) {
        return this.lineasPedidoController.CrearActualizarPedido(lineasPedidoDTO);
    }

    @PutMapping
    public LineasPedido ActualizarPedido(@RequestBody LineasPedidoDTO lineasPedidoDTO) {
        return this.lineasPedidoController.CrearActualizarPedido(lineasPedidoDTO);
    }

    @DeleteMapping("/{id}")
    public void DeletePedido(@PathVariable  int id) {
        this.lineasPedidoController.EliminarPedido(id);
    }



}
