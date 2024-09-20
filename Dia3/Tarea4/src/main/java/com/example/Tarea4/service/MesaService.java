package com.example.Tarea4.service;

import com.example.Tarea4.repository.MesaRepository;
import com.example.Tarea4.model.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas(){
        return mesaRepository.findAll();
    }

    public Mesa saveMesa(Mesa mesa){
        return mesaRepository.save(mesa);
    }

    public Mesa updateMesa(Long id, Mesa mesaDetails){
        Mesa mesa = mesaRepository.findById(id).orElseThrow();
        mesa.setOcupada(mesaDetails.isOcupada());
        return mesaRepository.save(mesa);
    }

    public void deleteMesa(Long id){
        mesaRepository.deleteById(id);
    }
}
