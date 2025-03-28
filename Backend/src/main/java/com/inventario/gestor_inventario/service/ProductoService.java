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

    /**
     * Retorna la cantidad total de productos
     * @return long
     */
    long totalCantidadStock();


    /**
     * Retorna la cantidad total de productos con stock bajo
     * @return long
     */
    long totalProductosStockBajo();

    /**
     * Retorna la cantidad total de productos con stock critico
     * @return long
     */
    long totalProductosStockCritico();

    /**
     * Obtiene los datos de un producto basándonos en el QR del mismo
     * @param codigo_qr
     * @return Objeto Producto
     */
    Producto obtenerProductoConQR(String codigo_qr);


}
