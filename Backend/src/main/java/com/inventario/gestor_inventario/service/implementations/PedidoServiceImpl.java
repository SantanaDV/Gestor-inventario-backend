package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Pedido;
import com.inventario.gestor_inventario.repository.PedidoRepository;
import com.inventario.gestor_inventario.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> ListarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido CrearActualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void EliminarPedido(int id) {
        this.pedidoRepository.deleteById(id);
    }


}
