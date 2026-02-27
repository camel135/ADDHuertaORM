package com.example.ADDHuerta.repository;

import com.example.ADDHuerta.dominio.Huerto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HuertoRepo extends JpaRepository<Huerto, Long> {

    // 1. CONSULTAS DERIVADAS

    List<Huerto> findByCultivoContaining(String p);

    List<Huerto> findByLocalizacionIgnoreCase(String l);

    long countByCultivo(String c);

    // 2. CONSULTAS JPQL con @Query

    @Query("SELECT h FROM Huerto h WHERE h.tamanio.valor > :valor")
    List<Huerto> buscarHuertosGrandes(@Param("valor") float valor);

    @Query("SELECT h FROM Huerto h WHERE h.persona.id = :id")
    List<Huerto> buscarPorIdDuenio(@Param("id") Long id);

    @Query("SELECT COUNT(h) FROM Huerto h WHERE h.localizacion = :loc")
    long totalEnCiudad(@Param("loc") String loc);

    // 3. CONSULTAS NATIVAS

    @Query(value = "SELECT * FROM huertos WHERE cultivo = ?1 LIMIT 1", nativeQuery = true)
    Huerto elPrimeroDeEseCultivo(String c);

    @Query(value = "SELECT localizacion FROM huertos GROUP BY localizacion", nativeQuery = true)
    List<String> todasLasCiudades();

    @Query(value = "DELETE FROM huertos WHERE persona_id IS NULL", nativeQuery = true)
    @Modifying
    @Transactional
    void limpiarHuertosHuerfanos();

    // consulta defensa:

}