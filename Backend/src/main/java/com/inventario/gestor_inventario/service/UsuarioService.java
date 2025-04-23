package com.inventario.gestor_inventario.service;

import com.inventario.gestor_inventario.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    /**
     * Metodo que Lista todos los usuarios
     * @return retorna una lista de usuarios
     */
    List<Usuario> ListarUsuarios();

    /**
     * Se encarga de Listar un usuario en concreto
     * @Param recibe un usuario para su listado
     * @return retorna el usuario que quermos ver
     */
    Usuario CrearActualizarUsuario(Usuario usuario);

    Usuario actualizarUsuario(Usuario usuario);
    /**
     * Se encarga de eliminar un uusuario recibiendo los datos
     * @Param recibe un usuario para su eliminacion
     */
    void EliminarUsuario(int id);

    Usuario BuscarUsuario(int id);

    Boolean ExisteUsuario(String email);

}
