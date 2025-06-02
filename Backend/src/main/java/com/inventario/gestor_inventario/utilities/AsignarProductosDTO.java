package com.inventario.gestor_inventario.utilities;

import java.util.List;

/**
 * Usado para asignar varios productos a una misma estantería:
 * {
 *   "id_estanteria": 5,
 *   "ids_producto": [12, 23, 42]
 * }
 */
public class AsignarProductosDTO {
    private Integer id_estanteria;
    private List<Integer> ids_producto;

    public Integer getId_estanteria() {
        return id_estanteria;
    }
    public void setId_estanteria(Integer id_estanteria) {
        this.id_estanteria = id_estanteria;
    }
    public List<Integer> getIds_producto() {
        return ids_producto;
    }
    public void setIds_producto(List<Integer> ids_producto) {
        this.ids_producto = ids_producto;
    }
}
