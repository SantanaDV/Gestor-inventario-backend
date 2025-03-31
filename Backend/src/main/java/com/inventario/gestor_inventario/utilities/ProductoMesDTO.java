package com.inventario.gestor_inventario.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoMesDTO {
    private long cantidad;
    private String mes;
    private String descripcion;


}
