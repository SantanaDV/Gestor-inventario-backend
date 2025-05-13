package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.repository.CategoriasProductoRepository;
import com.inventario.gestor_inventario.repository.LineasPedidoRepository;
import com.inventario.gestor_inventario.repository.PedidoRepository;
import com.inventario.gestor_inventario.repository.ProductoRepository;
import com.inventario.gestor_inventario.service.CategoriasProductoService;
import com.inventario.gestor_inventario.service.LineasPedidoService;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriasServiceImpl implements CategoriasProductoService {

    @Autowired
    private CategoriasProductoRepository categoriasProductoRepository;

    @Override
    public List<Categoria> ListarCategorias() {
        return categoriasProductoRepository.findAll();
    }

    @Override
    public Categoria crearActualizarCategorias(Categoria cate) {
        return categoriasProductoRepository.save(cate);
    }

    @Override
    public void EliminarCategoria(int id) {
        categoriasProductoRepository.deleteById(id);
    }
}
