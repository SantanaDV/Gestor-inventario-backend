package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.repository.LineasPedidoRepository;
import com.inventario.gestor_inventario.service.LineasPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LineasPedidoServiceImpl implements LineasPedidoService {

    @Autowired
    private LineasPedidoRepository lineasPedidoRepository;

    @Override
    public List<LineasPedido> ListarPedidos() {
        return lineasPedidoRepository.findAll();
    }

    @Override
    public LineasPedido CrearActualizarPedido(LineasPedido crearPedido) {
        return lineasPedidoRepository.save(crearPedido);
    }


    @Override
    public void EliminarPedido(int id) {
        lineasPedidoRepository.deleteById(id);
    }
}
