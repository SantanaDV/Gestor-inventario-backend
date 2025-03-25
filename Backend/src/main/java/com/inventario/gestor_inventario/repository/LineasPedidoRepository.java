package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.LineasPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineasPedidoRepository extends JpaRepository<LineasPedido,Integer> {

}
