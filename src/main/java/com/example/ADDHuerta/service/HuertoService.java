package com.example.ADDHuerta.service;

import com.example.ADDHuerta.dominio.Huerto;
import com.example.ADDHuerta.dominio.Persona;
import com.example.ADDHuerta.dominio.Tamanio;
import com.example.ADDHuerta.repository.HuertoRepo;
import com.example.ADDHuerta.repository.PersonaRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HuertoService {

    private final HuertoRepo huertoRepo;
    private final PersonaRepo personaRepo;

    public HuertoService(HuertoRepo huertoRepo, PersonaRepo personaRepo) {
        this.huertoRepo = huertoRepo;
        this.personaRepo = personaRepo;
    }

    public Huerto crearHuerto(String cultivo, String localizacion, Tamanio tamanio, Long idPersona) {
        // Existe la persona
        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no existe"));

        // Cultivo no vacío
        if (cultivo == null || cultivo.isBlank()) {
            throw new RuntimeException("El cultivo no puede estar vacío");
        }

        // Tamaño positivo (Nueva para la rúbrica)
        if (tamanio == null || tamanio.getValor() <= 0) {
            throw new RuntimeException("El tamaño debe ser mayor que cero");
        }

        return huertoRepo.save(new Huerto(cultivo, localizacion, persona, tamanio));
    }

    public List<Huerto> listar() {
        return huertoRepo.findAll();
    }
}