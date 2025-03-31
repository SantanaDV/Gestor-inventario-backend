package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;
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

    @Query(value = "SELECT SUM(cantidad),categorias.descripcion FROM productos INNER JOIN categorias ON categorias.id = productos.id_categoria GROUP BY categorias.id",nativeQuery = true)
    List<ProductoCatDTO> listarProductosCategorias();


    /**
     * Consulta que te retorna los productos que han entrado desde hace dos dias hasta el dia de hoy
     * @return List<Producto>
     */
    @Query(value ="SELECT pe.fecha,p.nombre,lp.cantidad,p.estado FROM Productos p INNER JOIN lineas_pedido lp ON lp.id_producto = p.id INNER JOIN pedidos pe ON pe.id = lp.id_pedido WHERE pe.tipo = 1 AND pe.fecha >= CURRENT_DATE - INTERVAL 2 DAY", nativeQuery = true)
    List<ProductosSalEntDTO> listarProductosEntrantesRecientes();

    @Query(value ="SELECT pe.fecha,p.nombre,lp.cantidad,p.estado  FROM productos p INNER JOIN lineas_pedido lp ON lp.id_producto = p.id INNER JOIN pedidos pe ON pe.id = lp.id_pedido WHERE pe.tipo = 2 AND pe.fecha >= CURRENT_DATE - INTERVAL 2 DAY ", nativeQuery = true)
    List<ProductosSalEntDTO> listarProductosSalientesRecientes();

}
