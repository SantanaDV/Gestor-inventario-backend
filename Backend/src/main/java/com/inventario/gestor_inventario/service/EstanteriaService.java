package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Estanteria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.utilities.EstanteriaAlmDTO;
import jakarta.transaction.Transactional;

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
    Estanteria CrearActualizarEstanteria(EstanteriaAlmDTO estanteria);


    /**
     * Elimino productos
     * @param id_estanteria toma un producto como parametro de entrada
     */
    void EliminarEstanteria(int id_estanteria);


    List<Estanteria> getEstanteriasByAlmacenId(int idAlmacen);


    void eliminarEstanteria(int idEstanteria);

    }
