package com.inventario.gestor_inventario.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private String nombre,contraseña;
    @Column(unique = true)
    private String email;
    private int estado;
    private Date fechaAlta, fecha_baja;
    @Column(name = "rol", columnDefinition = "ENUM('admin', 'empleado')")
    private String rol;

    //nuevo añadido por Mónica
    @ElementCollection(fetch = FetchType.EAGER) // Para cargar los roles inmediatamente
    @Enumerated(EnumType.STRING) // Para almacenar los roles como cadenas
    private Set<Rol> roles = new HashSet<>();

    public enum Rol {
        ADMIN, EMPLEADO
    }
}

