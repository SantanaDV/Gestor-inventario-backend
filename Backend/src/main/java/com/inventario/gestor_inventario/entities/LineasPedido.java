package com.inventario.gestor_inventario.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inventario.gestor_inventario.utilities.ProductoIdSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name="lineas_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineasPedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonSerialize(using = ProductoIdSerializer.class)
    private Producto producto;

    private int cantidad;

    private String estado;

    private Date fecha_salida;
}
