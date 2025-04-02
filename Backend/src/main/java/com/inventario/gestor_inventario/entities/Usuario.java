package com.inventario.gestor_inventario.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inventario.gestor_inventario.utilities.ProductoIdSerializer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Date;

import java.util.Optional;

import java.util.Collection;
import java.util.Collections;
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
    private Date fechaAlta;
    private Date fecha_baja;
    @Column(name = "rol", columnDefinition = "ENUM('admin', 'empleado')")
    private String rol;


    @Column(name = "rol", columnDefinition = "ENUM('admin', 'empleado')")
    // Método para obtener los roles en el formato que Spring Security espera

    @Transient
    @JsonIgnore
    public Optional<Object> getRoles() {
        return getRoles();
    }


    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Object getRol() {
        return null;
    }

    public int getEstado() {
        return 0;
    }

    public void setRol(String empleado) {
    }
}

