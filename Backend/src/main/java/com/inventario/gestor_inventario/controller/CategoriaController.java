package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.service.implementations.CategoriasServiceImpl;
import com.inventario.gestor_inventario.service.implementations.LineasPedidoServiceImpl;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private CategoriasServiceImpl categoriaServiceImpl;

    CategoriaController(CategoriasServiceImpl categoriaServiceImpl) {
        this.categoriaServiceImpl = categoriaServiceImpl;
    }

    @GetMapping
    public List<Categoria> ListarCategorias() {
        return categoriaServiceImpl.ListarCategorias();
    }

    @PostMapping
    public Categoria crearActualizarCategorias(@RequestBody Categoria categoria) {
        return categoriaServiceImpl.crearActualizarCategorias(categoria);
    }

    @PutMapping
    public Categoria actualizarCategorias(@RequestBody Categoria categoria) {
        return categoriaServiceImpl.crearActualizarCategorias(categoria);
    }

    @DeleteMapping("/{id}")
    public void DeleteCategoria(@PathVariable  int id) {
        this.categoriaServiceImpl.EliminarCategoria(id);
    }
}
