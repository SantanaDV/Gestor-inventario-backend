package com.inventario.gestor_inventario.controller;

import com.inventario.gestor_inventario.entities.Almacen;
import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.service.AlmacenService;
import com.inventario.gestor_inventario.service.implementations.AlmacenServiceImpl;
import com.inventario.gestor_inventario.service.implementations.CategoriasServiceImpl;
import com.inventario.gestor_inventario.service.implementations.LineasPedidoServiceImpl;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacen")
public class AlmacenController {

    private AlmacenServiceImpl almacenServiceImp;

    AlmacenController(AlmacenServiceImpl almacenServiceImp) {
        this.almacenServiceImp = almacenServiceImp;
    }

    @GetMapping
    public List<Almacen> ListarAlmacen() {
        return almacenServiceImp.listarAlmacen();
    }

    @PostMapping
    public Almacen crearActualizarAlmacen(@RequestBody Almacen almacen) {
        return almacenServiceImp.CrearActualizarAlmacen(almacen);
    }

    @PutMapping
    public Almacen actualizarAlmacen(@RequestBody Almacen almacen) {
        return almacenServiceImp.CrearActualizarAlmacen(almacen);
    }

    @DeleteMapping("/{id}")
    public void DeleteAlmacen(@PathVariable int id) {
        this.almacenServiceImp.EliminarAlmacen(id);
    }
}
