package com.inventario.gestor_inventario.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class EstadoNotificaciones {

    private String estado;
    public EstadoNotificaciones(){
        estado = "no leido";
    }
}
