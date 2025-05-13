package com.inventario.gestor_inventario.controller;


import com.inventario.gestor_inventario.entities.Notificacion;
import com.inventario.gestor_inventario.entities.Pedido;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private PedidoServiceImpl pedidoServiceImpl;

    public PedidoController(PedidoServiceImpl pedidoServiceImpl) {
        this.pedidoServiceImpl = pedidoServiceImpl;
    }

    @GetMapping
    public List<Pedido> ListarPedido(){
        return this.pedidoServiceImpl.ListarPedidos();
    }



    @PostMapping
    public Pedido CrearPedido(@RequestBody Pedido pedido) {
        return this.pedidoServiceImpl.CrearActualizarPedido(pedido);
    }

    @PutMapping
    public Pedido ActualizarPedido(@RequestBody Pedido pedido) {
        return this.pedidoServiceImpl.CrearActualizarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void EliminarPedido(@PathVariable  int id){
        this.pedidoServiceImpl.EliminarPedido(id);
    }



}
