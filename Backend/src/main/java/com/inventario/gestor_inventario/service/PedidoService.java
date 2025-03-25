package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Pedido;
import java.util.List;

public interface PedidoService {

    /**
     * Listar pedidos
     * @return List<Pedido>
     */
    List<Pedido> ListarPedidos();


    /**
     * Crear un pedido
     * @param  pedido creación de un pedido
     * @return crearPedido
     */
    Pedido CrearActualizarPedido(Pedido pedido);


    /**
     * Elimino los pedidos
     * @param id un parametro de entrada
     */
    void EliminarPedido(int id);

}
