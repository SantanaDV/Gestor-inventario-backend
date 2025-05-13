package com.inventario.gestor_inventario.service;
import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.CategoriaTarea;

import java.util.List;

public interface CategoriasTareaService {


    /**
     * Lista las categorias
     * @return List<Categorias>
     */
   List<CategoriaTarea> ListarCategorias();

    /**
     *
     * @param cate recibe una categoria
     * @return Categoria retorna una categoria
     */
   CategoriaTarea crearActualizarCategorias(CategoriaTarea cate);


    /**
     *
     * @param id recibe el id de una Categoria
     */
   void EliminarCategoria(int id);


}
