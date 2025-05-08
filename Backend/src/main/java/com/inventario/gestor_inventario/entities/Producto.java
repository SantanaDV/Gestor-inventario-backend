package com.inventario.gestor_inventario.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id_producto;

        private String nombre;
        private int cantidad;

        @Column(name = "estado", columnDefinition = "ENUM('activo', 'desactivado')")
        private String estado;

        @Column(name = "codigo_qr")
        private String codigoQr;

        @Column(name = "url_img", columnDefinition = "varchar(600)")
        private String url_img;

        private Date fecha_creacion;

        @Column(name = "nfc_id", unique = true)
        private String nfc_id;

        @Column(name = "posicion_product")
        private String posicion;

        @Column(name = "balda_producto", nullable = true)
        private Integer balda;

        @ManyToOne
        @JoinColumn(name = "id_categoria", nullable = false)
        private Categoria categoria;

        @ManyToOne
        @JoinColumn(name = "id_estanteria", nullable = false)
        private Estanteria estanteria;



}
