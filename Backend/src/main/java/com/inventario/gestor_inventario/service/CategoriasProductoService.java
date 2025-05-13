package com.inventario.gestor_inventario.service;
import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;

import java.util.List;

public interface CategoriasProductoService {


    /**
     * Lista las categorias
     * @return List<Categorias>
     */
   List<Categoria> ListarCategorias();

    /**
     *
     * @param cate recibe una categoria
     * @return Categoria retorna una categoria
     */
   Categoria crearActualizarCategorias(Categoria cate);


    /**
     *
     * @param id recibe el id de una Categoria
     */
   void EliminarCategoria(int id);


}
