package com.example.ADDHuerta.service;

import com.example.ADDHuerta.dominio.Huerto;
import com.example.ADDHuerta.dominio.Labor;
import com.example.ADDHuerta.repository.HuertoRepo;
import com.example.ADDHuerta.repository.LaborRepo;
import org.springframework.stereotype.Service;

@Service
public class LaborService {

    private final LaborRepo laborRepo;
    private final HuertoRepo huertoRepo;

    public LaborService(LaborRepo laborRepo, HuertoRepo huertoRepo) {
        this.laborRepo = laborRepo;
        this.huertoRepo = huertoRepo;
    }

    // no crear labor si el huerto no existe
    public Labor crearLabor(String descripcion, String fecha, Long idHuerto) {

        Huerto huerto = huertoRepo.findById(idHuerto)
                .orElseThrow(() -> new RuntimeException("Huerto no existe"));

        Labor labor = new Labor(descripcion, fecha, huerto);
        return laborRepo.save(labor);
    }
}