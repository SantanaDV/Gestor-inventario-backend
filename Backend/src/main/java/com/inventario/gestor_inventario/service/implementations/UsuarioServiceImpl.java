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
    public List<Usuario> ListarUsuarios() {
        return usuarioRepository.findAll();
    }


    @Override
    public Usuario CrearActualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void EliminarUsuario(int id) {usuarioRepository.deleteById(id);}

    @Override
    public Usuario BuscarUsuario(int id) {
        return usuarioRepository.findById(id).get();
    }


    public String obtenerUsuarioPorEmail (String email) {
        return usuarioRepository.findByEmail(email).getEmail();
    }
}
