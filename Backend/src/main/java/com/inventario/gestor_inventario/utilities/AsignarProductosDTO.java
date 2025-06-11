package com.inventario.gestor_inventario.utilities;

import java.util.List;
import java.util.Map;

/**
 * Usado para asignar varios productos a una misma estantería:
 * {
 *   "id_estanteria": 5,
 *   "ids_producto": [12, 23, 42]
 *   "ids_balda:[1-2,2-3]
 * }
 */
public class AsignarProductosDTO {
    private Integer id_estanteria;
    private List<Integer> ids_producto;
    private Map<Integer,Integer> baldas;

    public AsignarProductosDTO(Integer id_estanteria,
                               List<Integer> ids_producto,
                               Map<Integer,Integer> baldas) {
        this.id_estanteria = id_estanteria;
        this.ids_producto  = ids_producto;
        this.baldas        = baldas;
    }

    public AsignarProductosDTO() {
    }

    public Integer getId_estanteria() { return id_estanteria; }
    public void setId_estanteria(Integer id) { this.id_estanteria = id; }

    public List<Integer> getIds_producto() { return ids_producto; }
    public void setIds_producto(List<Integer> ids) { this.ids_producto = ids; }

    public Map<Integer,Integer> getBaldas() { return baldas; }
    public void setBaldas(Map<Integer,Integer> baldas) { this.baldas = baldas; }

    @Override
    public String toString() {
        return "AsignarProductosDTO{" +
                "id_estanteria=" + id_estanteria +
                ", ids_producto=" + ids_producto +
                ", baldas=" + baldas +
                '}';
    }
}
