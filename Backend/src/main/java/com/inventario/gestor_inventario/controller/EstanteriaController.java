package com.inventario.gestor_inventario.controller;
import com.inventario.gestor_inventario.entities.Categoria;
import com.inventario.gestor_inventario.entities.Estanteria;
import com.inventario.gestor_inventario.entities.LineasPedido;
import com.inventario.gestor_inventario.service.AlmacenService;
import com.inventario.gestor_inventario.service.implementations.AlmacenServiceImpl;
import com.inventario.gestor_inventario.service.implementations.CategoriasServiceImpl;
import com.inventario.gestor_inventario.service.implementations.EstanteriaServiceImpl;
import com.inventario.gestor_inventario.service.implementations.LineasPedidoServiceImpl;
import com.inventario.gestor_inventario.utilities.EstanteriaAlmDTO;
import com.inventario.gestor_inventario.utilities.LineasPedidoDTO;
import com.inventario.gestor_inventario.utilities.ProductoCatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estanteria")
public class EstanteriaController {

    private EstanteriaServiceImpl estanteriaServiceImp;

    EstanteriaController(EstanteriaServiceImpl estanteriaServiceImp) {
        this.estanteriaServiceImp = estanteriaServiceImp;
    }

    @GetMapping
    public List<Estanteria> ListarAlmacen() {
        return estanteriaServiceImp.listarEstanteria();
    }

    @PostMapping
    public Estanteria crearActualizarAlmacen(@RequestBody EstanteriaAlmDTO estanteria) {
        return estanteriaServiceImp.CrearActualizarEstanteria(estanteria);
    }

    @PutMapping
    public Estanteria actualizarAlmacen(@RequestBody EstanteriaAlmDTO estanteria) {
        return estanteriaServiceImp.CrearActualizarEstanteria(estanteria);
    }

    @DeleteMapping("/{id}")
    public void DeleteAlmacen(@PathVariable int id) {
        this.estanteriaServiceImp.EliminarEstanteria(id);
    }
}
