package com.example.Tarea4.service;

import com.example.Tarea4.model.Plato;
import com.example.Tarea4.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    public Plato savePlato(Plato plato) {
        return platoRepository.save(plato);
    }

    public Plato updatePlato(Long id, Plato platoDetails) {
        Plato plato = platoRepository.findById(id).orElseThrow();
        plato.setNombre(platoDetails.getNombre());
        plato.setPrecio(platoDetails.getPrecio());
        plato.setDisponibilidad(platoDetails.isDisponibilidad());
        return platoRepository.save(plato);
    }

    public void deletePlato(Long id) {
        platoRepository.deleteById(id);
    }
}
