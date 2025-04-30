package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.repository.CategoriasProductoRepository;
import com.inventario.gestor_inventario.repository.ProductoRepository;
import com.inventario.gestor_inventario.service.ProductoService;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import com.inventario.gestor_inventario.utilities.ProductoMesDTO;
import com.inventario.gestor_inventario.utilities.ProductosCantCat;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriasProductoRepository categoriasProductoRepository;


    @Override
    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }


    public int listarproductosContados() {
        return productoRepository.listarProductoscontados();
    }
    public List<Producto> listarConExistencias(){
        return productoRepository.findAll();
    }
    public List<Producto>listarConFaltantes(){
        return productoRepository.findAll();
    }

    @Override
    public Producto CrearActualizarProducto(ProductoCatDTO producto) {
        Producto p = new Producto();
        p.setId_producto(producto.getId_producto());
        p.setCategoria(categoriasProductoRepository.findById(producto.getId_categoria()).orElse(null));
        p.setEstado(producto.getEstado());
        p.setCantidad(producto.getCantidad());
        p.setNombre(producto.getNombre());
        p.setNfc_id(producto.getNfc_id());
        p.setFecha_creacion(producto.getFecha_creacion());
        p.setUrl_img(producto.getUrl_img());
        p.setCodigoQr(producto.getCodigoQr());
        return productoRepository.save(p);
    }

    @Override
    public void EliminarProducto(Producto producto) {
        productoRepository.delete(producto);
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

    @Override
    public List<ProductosCantCat> listarProductosCategorias() {
        return productoRepository.listarProductosCategorias();
    }
    @Override
    public List<ProductoMesDTO> listarProductosMes(){
        return productoRepository.listarProductosMes();
    }
}
