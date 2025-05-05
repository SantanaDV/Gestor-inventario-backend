package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Almacen;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import com.inventario.gestor_inventario.utilities.ProductoMesDTO;
import com.inventario.gestor_inventario.utilities.ProductosCantCat;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;

import java.util.List;

public interface AlmacenService {

    /**
     * Lista de productos
     * @return List<Producto> retorna una lista de productos
     */
    List<Almacen> listarAlmacen();

    /**
     * Creo un producto
     * @param almacen encarga de crear un poducto
     * @return Producto crearProducto
     */
    Almacen CrearActualizarAlmacen(Almacen almacen);


    /**
     * Elimino productos
     * @param id_almacen toma un producto como parametro de entrada
     */
    void EliminarAlmacen(int id_almacen);
}
