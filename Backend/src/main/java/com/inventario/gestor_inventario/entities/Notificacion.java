package com.inventario.gestor_inventario.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="notificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {
    private int id;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @Column(name="url_img", columnDefinition = "TEXT")
    private String mensaje;
    private String tipo;
    private Date fecha_creacion;

    private String estado;
}
