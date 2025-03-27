package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.repository.ProductoRepository;
import com.inventario.gestor_inventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto CrearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void EliminarProducto(Producto producto) {
        productoRepository.deleteById(producto.getId_producto());
    }
}
