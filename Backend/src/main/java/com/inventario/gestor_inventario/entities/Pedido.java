package com.inventario.gestor_inventario.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private int id,estdo,tipo;
    private Date fecha,fecha_creacion;
}
