package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasProductoRepository extends JpaRepository<Categoria,Integer> {

}
