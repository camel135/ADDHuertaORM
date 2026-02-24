package com.example.ADDHuerta.repository;

import com.example.ADDHuerta.dominio.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface LaborRepo extends JpaRepository<Labor, Long> {

    // Consulta derivada
    List<Labor> findByDescripcion(String descripcion);

    // JPQL
    @Query("SELECT l FROM Labor l WHERE l.huerto.cultivo = :cultivo")
    List<Labor> buscarPorCultivoHuerto(String cultivo);

    // Nativa
    @Query(value = "SELECT * FROM labores WHERE fecha_limite = ?1", nativeQuery = true)
    List<Labor> buscarPorFechaNativa(String fecha);
}