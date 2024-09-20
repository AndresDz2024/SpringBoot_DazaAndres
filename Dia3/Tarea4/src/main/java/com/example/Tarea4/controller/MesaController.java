package com.example.Tarea4.controller;

import com.example.Tarea4.model.Mesa;
import com.example.Tarea4.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    //Obtener todos los mesas con metodo get
    @GetMapping
    public List<Mesa> getAllPlato() {
        return mesaService.getAllMesas();
    }

    //Guardar mesas con metodo post
    @PostMapping
    public Mesa createPlato(@RequestBody Mesa mesa) {
        return mesaService.saveMesa(mesa);
    }

    //Actualizar mesa con metodo put
    @PutMapping("/{id}")
    public Mesa updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        return mesaService.updateMesa(id, mesa);
    }

    //Eliminar mesa con metodo delete
    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
    }
}


