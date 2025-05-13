package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.CategoriaTarea;
import com.inventario.gestor_inventario.repository.CategoriasTareasRepository;
import com.inventario.gestor_inventario.service.CategoriasProductoService;
import com.inventario.gestor_inventario.service.CategoriasTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasTareasServiceImpl implements CategoriasTareaService {

    @Autowired
    private CategoriasTareasRepository categoriasTareasRepository;

    @Override
    public List<CategoriaTarea> ListarCategorias() {
        return categoriasTareasRepository.findAll();
    }


    @Override
    public CategoriaTarea crearActualizarCategorias(CategoriaTarea cate) {
        return categoriasTareasRepository.save(cate);
    }

    @Override
    public void EliminarCategoria(int id) {
        categoriasTareasRepository.deleteById(id);
    }
}
