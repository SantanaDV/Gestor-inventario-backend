package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    /**
     * Query en JPA para contar la cantidad total de productos
     * @return long
     */
    @Query("SELECT SUM(p.cantidad) FROM Producto p")
    long contarTotalCantidadStock();

    /**
     * Query en JPA que cuenta la cantidad total de productos con cantidad menor o igual a 5
     * @return long
     */
    @Query("SELECT p FROM Producto p WHERE p.cantidad BETWEEN 3 AND 10 AND p.estado='activo'")
    List<Producto> contarTotalProductosStockBajo();

    /**
     * Query en JPA que cuenta la cantidad total de productos con cantidad menor o igual a 2
     * @return long
     */
    @Query("SELECT p FROM Producto p WHERE p.cantidad <=2 AND p.estado='activo'")
    List<Producto> contarTotalProductosStockCritico();

    /**
     * Devolvemos la información de producto en base al QR
     * @param codigo_qr
     * @return Objeto Producto
     */
    Producto findByCodigoQr(String codigo_qr);




}
