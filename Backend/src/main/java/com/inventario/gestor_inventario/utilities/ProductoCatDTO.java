package com.inventario.gestor_inventario.utilities;


import com.inventario.gestor_inventario.entities.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCatDTO {

    private int id_producto;
    private int id_categoria;

    private String nombre;
    private int cantidad;

    private String estado;

    private String codigoQr;

    private String url_img;

    private Date fecha_creacion;

    private String nfc_id;
    private int id_estanteria;
}
