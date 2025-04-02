package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
