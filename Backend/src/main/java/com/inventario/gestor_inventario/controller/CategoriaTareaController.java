package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.CategoriaTarea;
import com.inventario.gestor_inventario.service.implementations.CategoriasServiceImpl;
import com.inventario.gestor_inventario.service.implementations.CategoriasTareasServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriatarea")
public class CategoriaTareaController {

    private CategoriasTareasServiceImpl categoriaServiceImpl;

    CategoriaTareaController(CategoriasTareasServiceImpl categoriaServiceImpl) {
        this.categoriaServiceImpl = categoriaServiceImpl;
    }

    @GetMapping
    public List<CategoriaTarea> ListarCategorias() {
        return categoriaServiceImpl.ListarCategorias();
    }

    @PostMapping
    public CategoriaTarea crearActualizarCategorias(@RequestBody CategoriaTarea categoria) {
        return categoriaServiceImpl.crearActualizarCategorias(categoria);
    }

    @PutMapping
    public CategoriaTarea actualizarCategorias(@RequestBody CategoriaTarea categoria) {
        return categoriaServiceImpl.crearActualizarCategorias(categoria);
    }

    @DeleteMapping("/{id}")
    public void DeleteCategoria(@PathVariable  int id) {
        this.categoriaServiceImpl.EliminarCategoria(id);
    }
}
