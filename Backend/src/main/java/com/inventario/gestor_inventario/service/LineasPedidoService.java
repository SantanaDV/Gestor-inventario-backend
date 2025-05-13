package com.inventario.gestor_inventario.service;
import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;

import java.util.List;

public interface LineasPedidoService {


    /**
     * Lista los pedidos
     * @return List<lineasPedido>
     */
   List<LineasPedidoDTO> ListarPedidos();

    /**
     *
     * @param pedido recibe un pedido
     * @return lineasPedido
     */
   LineasPedido CrearActualizarPedido(LineasPedidoDTO pedido);


    /**
     *
     * @param id recibe una lista
     */
   void EliminarPedido(int id);


}
