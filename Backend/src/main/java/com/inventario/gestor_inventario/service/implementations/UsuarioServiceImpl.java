package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Usuario;
import com.inventario.gestor_inventario.repository.UsuarioRepository;
import com.inventario.gestor_inventario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Integer listarUsuariosActivos(){ return usuarioRepository.findAll().size() ; }

    @Override
    public List<Usuario> ListarUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> ListarUsuariosActivos(){ return usuarioRepository.findAll(); }


    @Override
    public Usuario CrearActualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioExistente) {
        // Aquí realizamos la actualización de los campos necesarios
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void EliminarUsuario(int id) {usuarioRepository.deleteById(id);}

    @Override
    public Usuario BuscarUsuario(int id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Boolean ExisteUsuario(String email) {
        return usuarioRepository.existsByEmail(email);
    }


    public String obtenerUsuarioPorEmail (String email) {
        return usuarioRepository.findByEmail(email).getEmail();
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}
