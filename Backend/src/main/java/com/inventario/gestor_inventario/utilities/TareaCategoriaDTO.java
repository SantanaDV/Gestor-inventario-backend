package com.inventario.gestor_inventario.utilities;

import com.inventario.gestor_inventario.entities.Tarea;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class TareaCategoriaDTO {
    private int id;
    private String descripcion;

    public String getEstado() {
        return "";
    }

    public enum Estado {
        Por_hacer("Por hacer"),
        En_proceso("En Proceso"),
        Finalizada("Finalizada");

        Estado(String s) {
        }
    }
    private String empleado_asignado;
    private Date fecha_asignacion,fecha_finalizacion;
    private int id_categoria;

    public TareaCategoriaDTO(int id, String descripcion, String estado, String empleado_asignado, Date fecha_asignacion, Date fecha_finalizacion, int id_categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.empleado_asignado = empleado_asignado;
        this.fecha_asignacion = fecha_asignacion;
        this.fecha_finalizacion = fecha_finalizacion;
        this.id_categoria = id_categoria;
    }
//    public TareaCategoriaDTO(int id, String descripcion, Tarea.Estado estado, String empleado_asignado, Date fecha_asignacion, Date fecha_finalizacion, int id_categoria) {
//        this.id = id;
//        this.descripcion = descripcion;
//        this.empleado_asignado = empleado_asignado;
//        this.fecha_asignacion = fecha_asignacion;
//        this.fecha_finalizacion = fecha_finalizacion;
//        this.id_categoria = id_categoria;
//    }
}

