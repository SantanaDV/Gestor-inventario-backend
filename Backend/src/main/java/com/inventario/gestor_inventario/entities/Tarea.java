package com.inventario.gestor_inventario.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name="tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private String empleado_asignado;

    @NotNull
    @Column(name = "estado", columnDefinition = "ENUM('Por hacer', 'En Proceso', 'Finalizada')")
    private String estado;


    private Date fecha_asignacion;
    private Date fecha_finalizacion;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaTarea categoria;

    public String getEstado() {
        return estado != null ? estado : "";
    }

    public void setCategoria(int idCategoria) {
    }
}




