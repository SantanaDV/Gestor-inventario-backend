package com.inventario.gestor_inventario.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EstadoProductos {
    private String estado;

    public EstadoProductos(){
        estado = "desactivado";
    }


}
