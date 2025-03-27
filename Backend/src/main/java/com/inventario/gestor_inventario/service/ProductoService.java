package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Producto;

import java.util.List;

public interface ProductoService {

    /**
     * Lista de productos
     * @return List<Producto> retorna una lista de productos
     */
    List<Producto> listarProductos();

    /**
     * Creo un producto
     * @param producto encarga de crear un poducto
     * @return Producto crearProducto
     */
    Producto CrearActualizarProducto(Producto producto);


    /**
     * Elimino productos
     * @param producto toma un producto como parametro de entrada
     */
    void EliminarProducto(Producto producto);
}
