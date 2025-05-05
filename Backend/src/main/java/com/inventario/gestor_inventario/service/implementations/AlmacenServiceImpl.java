package com.inventario.gestor_inventario.service.implementations;

import com.inventario.gestor_inventario.entities.Almacen;
import com.inventario.gestor_inventario.entities.Estanteria;
import com.inventario.gestor_inventario.entities.Producto;
import com.inventario.gestor_inventario.repository.AlmacenRepository;
import com.inventario.gestor_inventario.repository.EstanteriaRepository;
import com.inventario.gestor_inventario.service.AlmacenService;
import com.inventario.gestor_inventario.service.EstanteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public List<Almacen> listarAlmacen() {
        return almacenRepository.findAll();
    }

    @Override
    public Almacen CrearActualizarAlmacen(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    @Override
    public void EliminarAlmacen(int id_almacen) {
        almacenRepository.deleteById(id_almacen);
    }
}
