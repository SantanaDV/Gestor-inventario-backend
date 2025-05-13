package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Almacen;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.utilities.ProductoMesDTO;
import com.inventario.gestor_inventario.utilities.ProductosCantCat;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {

}

