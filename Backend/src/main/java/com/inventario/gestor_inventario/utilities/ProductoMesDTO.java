package com.inventario.gestor_inventario.utilities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class ProductoMesDTO {
    private BigInteger totalCantidad;
    private String mes;

    // Constructor que acepta cualquier tipo numérico y lo convierte a BigInteger
    public ProductoMesDTO(Number totalCantidad, String mes) {
        this.totalCantidad = BigInteger.valueOf(totalCantidad.longValue());
        this.mes = mes;
    }
}
