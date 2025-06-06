package com.inventario.gestor_inventario.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "estanteria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estanteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_estanteria;

    private String posicion;

    @ManyToOne
    @JoinColumn(name = "id_almacen", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Almacen almacen;


    @Column(name = "orientacion", columnDefinition = "ENUM('horizontal', 'vertical')")
    private String orientacion;

}
