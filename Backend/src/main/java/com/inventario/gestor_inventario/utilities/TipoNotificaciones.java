package com.inventario.gestor_inventario.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TipoNotificaciones {

    private String tipo;

    public TipoNotificaciones(){
        tipo="otro";
    }
}
