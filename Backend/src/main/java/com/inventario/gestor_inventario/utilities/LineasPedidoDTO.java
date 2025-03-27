package com.inventario.gestor_inventario.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineasPedidoDTO{
    private int id,id_producto,id_pedido,cantidad;
    private String estado;

}
