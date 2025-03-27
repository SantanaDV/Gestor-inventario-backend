package com.inventario.gestor_inventario.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @Column(name="mensaje", columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "tipo", columnDefinition = "ENUM('stock bajo', 'tarea asignada', 'otro')")
    private String tipo;
    private Date fecha_creacion;

    @Column(name = "estado", columnDefinition = "ENUM('no leido', 'leido')")
    private String estado;
}
