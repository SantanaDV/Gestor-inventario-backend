package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Estanteria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.repository.AlmacenRepository;
import com.inventario.gestor_inventario.repository.CategoriasProductoRepository;
import com.inventario.gestor_inventario.repository.EstanteriaRepository;
import com.inventario.gestor_inventario.repository.ProductoRepository;
import com.inventario.gestor_inventario.service.EstanteriaService;
import com.inventario.gestor_inventario.service.ProductoService;
import com.inventario.gestor_inventario.utilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstanteriaServiceImpl implements EstanteriaService {

    @Autowired
    private EstanteriaRepository estanteriaRepository;
    @Autowired
    private AlmacenRepository almacenRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Estanteria> listarEstanteria() {
        return estanteriaRepository.findAll();
    }

    @Override
    public Estanteria CrearActualizarEstanteria(EstanteriaAlmDTO estanteria) {
        Estanteria es = new Estanteria();
        es.setId_estanteria(estanteria.getId_estanteria());
        es.setPosicion(estanteria.getPosicion());
        es.setOrientacion(estanteria.getOrientacion());
        es.setAlmacen(almacenRepository.findById(estanteria.getId_almacen()).orElse(null));
        return estanteriaRepository.save(es);
    }
    @Override
    public List<Estanteria> getEstanteriasByAlmacenId(int idAlmacen) {
        return estanteriaRepository.findByAlmacenIdAlmacen(idAlmacen);
    }

    @Override
    public void EliminarEstanteria(int estanteria) {
        estanteriaRepository.deleteById(estanteria);
    }

    @Override
    public void eliminarEstanteria(int idEstanteria) {
        productoRepository.desasociarProductosDeEstanteria(idEstanteria);
        estanteriaRepository.deleteById(idEstanteria);
    }
}
