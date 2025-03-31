package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Pedido;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.service.implementations.ProductoServiceImpl;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private ProductoServiceImpl productoServiceImpl;

    public ProductoController(ProductoServiceImpl productoServiceImpl) {
        this.productoServiceImpl = productoServiceImpl;
    }

    @GetMapping
    public List<Producto> ListarProducto(){
        return this.productoServiceImpl.listarProductos();
    }

    @GetMapping("/obtenerProductoQR/{codigo_qr}")
    @PreAuthorize("hasRole('EMPLEADO') or hasRole('ADMIN')")
    public Producto obtenerProductoPorQR(@PathVariable String codigo_qr){
        return productoServiceImpl.obtenerProductoConQR(codigo_qr);
    }

    @PostMapping
    public Producto CrearProducto(@RequestBody ProductoCatDTO producto) {
        return this.productoServiceImpl.CrearActualizarProducto(producto);
    }

    @PutMapping
    public Producto ActualizarProducto(@RequestBody ProductoCatDTO producto) {
        return this.productoServiceImpl.CrearActualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {
        this.eliminarProducto(id);
    }


}
