package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Estanteria;
import com.inventario.gestor_inventario.entities.Producto;

import java.util.List;

public interface EstanteriaService {

    /**
     * Lista de productos
     * @return List<Producto> retorna una lista de productos
     */
    List<Estanteria> listarEstanteria();

    /**
     * Creo un producto
     * @param estanteria encarga de crear un poducto
     * @return Producto crearProducto
     */
    Estanteria CrearActualizarEstanteria(Estanteria estanteria);


    /**
     * Elimino productos
     * @param estanteria toma un producto como parametro de entrada
     */
    void EliminarEstanteria(int id_estanteria);
}
