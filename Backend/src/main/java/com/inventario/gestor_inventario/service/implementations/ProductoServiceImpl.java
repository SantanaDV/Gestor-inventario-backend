package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.repository.ProductoRepository;
import com.inventario.gestor_inventario.service.ProductoService;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;
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
    public Producto CrearActualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void EliminarProducto(Producto producto) {
        productoRepository.deleteById(producto.getId_producto());
    }

    @Override
    public long totalCantidadStock() {
        return productoRepository.contarTotalCantidadStock();
    }

    @Override
    public List<Producto> totalProductosStockBajo() {
        return productoRepository.contarTotalProductosStockBajo();
    }

    @Override
    public List<Producto> totalProductosStockCritico() {
        return productoRepository.contarTotalProductosStockCritico();
    }

    @Override
    public Producto obtenerProductoConQR(String codigo_qr) {
        return productoRepository.findByCodigoQr(codigo_qr);
    }


    public List<ProductosSalEntDTO> listarProductosEntrantesRecientes() {
        return productoRepository.listarProductosEntrantesRecientes();
    }
    @Override
    public List<ProductosSalEntDTO> listarProductosSalientesRecientes() {
        return productoRepository.listarProductosSalientesRecientes();
    }
}
