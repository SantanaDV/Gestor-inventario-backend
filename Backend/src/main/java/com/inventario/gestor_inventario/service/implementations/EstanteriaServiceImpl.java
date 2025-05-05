package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Estanteria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.repository.CategoriasProductoRepository;
import com.inventario.gestor_inventario.repository.EstanteriaRepository;
import com.inventario.gestor_inventario.repository.ProductoRepository;
import com.inventario.gestor_inventario.service.EstanteriaService;
import com.inventario.gestor_inventario.service.ProductoService;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import com.inventario.gestor_inventario.utilities.ProductoMesDTO;
import com.inventario.gestor_inventario.utilities.ProductosCantCat;
import com.inventario.gestor_inventario.utilities.ProductosSalEntDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstanteriaServiceImpl implements EstanteriaService {

    @Autowired
    private EstanteriaRepository estanteriaRepository;

    @Override
    public List<Estanteria> listarEstanteria() {
        return estanteriaRepository.findAll();
    }

    @Override
    public Estanteria CrearActualizarEstanteria(Estanteria estanteria) {
        return estanteriaRepository.save(estanteria);
    }

    @Override
    public void EliminarEstanteria(int estanteria) {
        estanteriaRepository.deleteById(estanteria);
    }
}
