package com.inventario.gestor_inventario.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionesDTO {
    private int id,usuario_id;
    private String estado;
    private Date fecha_creacion;
    private String mensaje,tipo;


}
