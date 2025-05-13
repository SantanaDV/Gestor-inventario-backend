package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.CategoriaTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasTareasRepository extends JpaRepository<CategoriaTarea,Integer> {

}
