package com.inventario.gestor_inventario.repository;

import com.inventario.gestor_inventario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    /**
     * Busca un usuario por el email
     * @param email
     * @return Objeto Usuario
     */
    Usuario findByEmail(String email);

    /**
     * Devuelve true si el email ya está en uso o false en caso contrario
     * @param email
     * @return
     */
    Boolean existsByEmail(String email);



    @Query("SELECT COUNT(*) FROM Usuario WHERE fecha_baja IS  NULL ")
    Integer listarUsuariosActivos();
}
