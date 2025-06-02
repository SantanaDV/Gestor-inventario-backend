package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import com.inventario.gestor_inventario.utilities.ProductoMesDTO;
import com.inventario.gestor_inventario.utilities.ProductosCantCat;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    /**
     * Lista de productos
     * @return List<Producto> retorna una lista de productos
     */
    List<Producto> listaProductos();

    /**
     * Creo un producto
     * @param producto encarga de crear un poducto
     * @return Producto crearProducto
     */
    Producto CrearActualizarProducto(ProductoCatDTO producto);


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
    List<Producto> totalProductosStockBajo();

    /**
     * Retorna la cantidad total de productos con stock critico
     * @return long
     */
    List<Producto> totalProductosStockCritico();

    /**
     * Obtiene los datos de un producto basándonos en el QR del mismo
     * @param codigo_qr
     * @return Objeto Producto
     */
    Producto obtenerProductoConQR(String codigo_qr);


    /**
     * Retorna los productos entrantes recientes
     * @return List<Producto>
     */
    List<ProductosSalEntDTO>listarProductosEntrantesRecientes();


    /**
     * Retorna los productos salientes recientes
     * @return List<Producto>
     */
    List<ProductosSalEntDTO>listarProductosSalientesRecientes();

    /**
     * Retorna las categorias y las cantidades de cada una
     * @return List<ProductosCantCat> retorna productos con sus cantidades
     */
    List<ProductosCantCat>listarProductosCategorias();

    /**
     * Retorna el stock de productos por cada mes
     * @return List<Producto>
     */
    List<ProductoMesDTO>listarProductosMes();

    Optional<Producto> obtenerPorId(int idProd);
}
