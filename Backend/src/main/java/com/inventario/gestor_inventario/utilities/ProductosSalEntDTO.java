package com.inventario.gestor_inventario.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosSalEntDTO{
    private Date fecha;
    private String nombre;
    private int cantidad;
    private String estado;

}