package com.inventario.gestor_inventario.utilities;

import com.inventario.gestor_inventario.entities.CategoriaTarea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaCategoriaDTO {
    private int id;
    private String descripcion;
    private String estado;
    private String empleado_asignado;
    private Date fecha_asignacion,fecha_finalizacion;
    private int id_categoria;
}
