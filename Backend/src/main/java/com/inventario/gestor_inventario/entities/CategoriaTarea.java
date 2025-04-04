package com.inventario.gestor_inventario.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="categoriasTarea")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoriaTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;
}
