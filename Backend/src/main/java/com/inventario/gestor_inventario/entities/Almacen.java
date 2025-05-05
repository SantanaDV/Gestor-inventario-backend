package com.inventario.gestor_inventario.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "almacen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_almacen;

    private int fila;
    private int columna;

    @Column(name = "ubicacion")
    private String ubicacion;
    
}
