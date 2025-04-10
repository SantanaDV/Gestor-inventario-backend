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
        private int pedido;
        private int id;

        private int id_pedido;

        @Column(name = "estado", columnDefinition = "ENUM('activo', 'desactivado')")
        private String estado;

        @Column(name = "codigo_qr")
        private String codigoQr;

        @Column(name = "url_img", columnDefinition = "varchar(600)")
        private String url_img;

        private Date fecha_creacion;

        @Column(name = "nfc_id", unique = true)
        private String nfc_id;

        @ManyToOne
        @JoinColumn(name = "id_categoria", nullable = false)
        private Categoria categoria;

        public int getCantidad() {
            return 0;
        }

        public int getId_producto() {
                return id_producto;
        }

        public void setId_producto(int id_producto) {
                this.id_producto = id_producto;
        }
}
