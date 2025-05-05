package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Almacen;
import com.inventario.gestor_inventario.entities.Estanteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstanteriaRepository extends JpaRepository<Estanteria, Integer> {

}

