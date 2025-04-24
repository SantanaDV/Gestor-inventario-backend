package com.inventario.gestor_inventario.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

import java.util.Optional;


@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_usuario;
    private String nombre,contrasena;
    @Column(unique = true)
    private String email;
    private int estado;

    private Date fechaAlta, fecha_baja;
    @Column(name = "rol", columnDefinition = "ENUM('admin', 'empleado')")
    private String rol;
    @Transient
    @JsonIgnore
    public Optional<Object> getRoles() {
        return Optional.empty();
    }




}

