package com.example.Tarea1.Controlador;

import com.example.Tarea1.Modelo.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    private List<Persona> personas = new ArrayList<>();

    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("personas", personas);
        return "personas";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "nueva-persona";
    }

    @PostMapping
    public String guardarPersona(@ModelAttribute Persona persona) {
        personas.add(persona);
        return "redirect:/personas";
    }

    @GetMapping("/buscar")
    public String buscarPersona(@RequestParam String nombre, Model model) {
        Optional<Persona> persona = personas.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
        model.addAttribute("persona", persona.orElse(null));
        return "resultado-busqueda";
    }
}
