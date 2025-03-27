package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);



}
