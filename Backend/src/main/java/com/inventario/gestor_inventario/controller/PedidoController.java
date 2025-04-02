package com.inventario.gestor_inventario.controller;


import com.inventario.gestor_inventario.entities.Notificacion;
import com.inventario.gestor_inventario.entities.Pedido;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('EMPLEADO')")
    public ResponseEntity<?> EliminarPedido(@PathVariable int id) {
        try {
            int resultado = pedidoServiceImpl.EliminarPedido(id);
            if (resultado >0) {
                return ResponseEntity.ok().body("Pedido eliminado correctamente. Registro eliminado: " + resultado);
            }else {
                return ResponseEntity.notFound().build();

            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, el pedido ya no existe: " + e.getMessage());
        }

    }

}
