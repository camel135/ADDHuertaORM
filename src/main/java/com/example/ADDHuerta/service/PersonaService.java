package com.example.ADDHuerta.service;

import com.example.ADDHuerta.dominio.Persona;
import com.example.ADDHuerta.repository.PersonaRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepo personaRepo;

    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    public Persona guardar(String nombre, String apellido) {
        return personaRepo.save(new Persona(nombre, apellido));
    }

    public List<Persona> listarTodas() {
        return personaRepo.findAll();
    }
}