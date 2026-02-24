package com.example.ADDHuerta.repository;

import com.example.ADDHuerta.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonaRepo extends JpaRepository<Persona, Long> {

    // Consulta derivada
    List<Persona> findByNombre(String nombre);

    // Consulta derivada
    List<Persona> findByApellidoContaining(String texto);

}