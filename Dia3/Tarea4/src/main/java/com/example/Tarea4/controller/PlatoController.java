package com.example.Tarea4.controller;

import com.example.Tarea4.model.Plato;
import com.example.Tarea4.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    //Obtener todos los platos con metodo get
    @GetMapping
    public List<Plato> getAllPlato() {
        return platoService.getAllPlatos();
    }

    //Guardar platos con metodo post
    @PostMapping
    public Plato createPlato(@RequestBody Plato plato) {
        return platoService.savePlato(plato);
    }

    //Actualizar plato con metodo put
    @PutMapping("/{id}")
    public Plato updatePlato(@PathVariable Long id, @RequestBody Plato plato) {
        return platoService.updatePlato(id, plato);
    }

    //Eliminar plato con metodo delete
    @DeleteMapping("/{id}")
    public void deletePlato(@PathVariable Long id) {
        platoService.deletePlato(id);
    }
}


