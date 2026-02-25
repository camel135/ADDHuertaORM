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

    public Huerto crearHuerto(String cultivo, String localizacion,
                              Tamanio tamanio, Long idPersona) {

        Persona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no existe"));

        if (cultivo == null || cultivo.isBlank()) {
            throw new RuntimeException("El cultivo no puede estar vacío");
        }

        Huerto huerto = new Huerto(cultivo, localizacion, persona, tamanio);
        return huertoRepo.save(huerto);
    }

    public List<Huerto> listar() {
        return huertoRepo.findAll();
    }
}