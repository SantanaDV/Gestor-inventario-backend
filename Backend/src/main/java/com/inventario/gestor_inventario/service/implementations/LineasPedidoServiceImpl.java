package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.repository.LineasPedidoRepository;
import com.inventario.gestor_inventario.repository.PedidoRepository;
import com.inventario.gestor_inventario.repository.ProductoRepository;
import com.inventario.gestor_inventario.service.LineasPedidoService;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineasPedidoServiceImpl implements LineasPedidoService {

    @Autowired
    private LineasPedidoRepository lineasPedidoRepository;
    @Autowired
    private ProductoRepository productoController;
    @Autowired
    private PedidoRepository pedidoController;

    @Override
    public List<LineasPedidoDTO> ListarPedidos() {
        List<LineasPedido> lineasPedido = lineasPedidoRepository.findAll();
        List<LineasPedidoDTO> lineas = lineasPedido.stream()
                .map(n -> new LineasPedidoDTO(
                        n.getId(),
                        n.getProducto().getId_producto(),
                        n.getPedido().getId_pedido(),
                        n.getCantidad(),
                        n.getEstado()
                ))
                .collect(Collectors.toList());

        return lineas;
    }

    @Override
    public LineasPedido CrearActualizarPedido(LineasPedidoDTO lineasPedidoDTO) {
        LineasPedido lineasPedido = new LineasPedido();
        lineasPedido.setId(lineasPedidoDTO.getId());
        lineasPedido.setPedido(pedidoController.findById(lineasPedidoDTO.getId_pedido()).orElse(null));
        lineasPedido.setProducto(productoController.findById(lineasPedidoDTO.getId_producto()).orElse(null));
        lineasPedido.setCantidad(lineasPedidoDTO.getCantidad());
        lineasPedido.setEstado(lineasPedidoDTO.getEstado());
        return lineasPedidoRepository.save(lineasPedido);
    }


    @Override
    public void EliminarPedido(int id) {
        lineasPedidoRepository.deleteById(id);
    }
}
