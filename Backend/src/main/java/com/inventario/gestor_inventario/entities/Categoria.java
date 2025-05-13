package com.inventario.gestor_inventario.entities;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inventario.gestor_inventario.utilities.ProductoIdSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

}
