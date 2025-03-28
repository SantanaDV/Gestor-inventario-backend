package com.inventario.gestor_inventario.entities;

import jakarta.persistence.*;
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
    @Column(name = "estado", columnDefinition = "ENUM('Por hacer', 'En Proceso', 'Finalizada')")
    private String estado;

    @ManyToMany // Relación muchos a uno con Usuario(empleado responsable)
    @JoinColumn(name = "empleado_asignado") // columna que almacena la clave foránea
    private String empleado_asignado;
    private Date fecha_asignacion,fecha_finalizacion;
}
