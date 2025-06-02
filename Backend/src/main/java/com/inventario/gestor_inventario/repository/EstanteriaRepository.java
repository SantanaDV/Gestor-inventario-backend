package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Almacen;
import com.inventario.gestor_inventario.entities.Estanteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstanteriaRepository extends JpaRepository<Estanteria, Integer> {

    @Query("SELECT e FROM Estanteria e WHERE e.almacen.id_almacen = :idAlmacen")
    List<Estanteria> findByAlmacenIdAlmacen(@Param("idAlmacen") int idAlmacen);

    Estanteria getEstanteriaById_estanteria(int idEstanteria);
}

