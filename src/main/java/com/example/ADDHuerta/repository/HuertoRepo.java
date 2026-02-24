package com.example.ADDHuerta.repository;

import com.example.ADDHuerta.dominio.Huerto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HuertoRepo extends JpaRepository<Huerto, Long> {

    // 1. CONSULTAS DERIVADAS (3)
    List<Huerto> findByCultivoContaining(String p);
    List<Huerto> findByLocalizacionIgnoreCase(String l);
    long countByCultivo(String c);

    // 2. CONSULTAS JPQL con @Query (3)
    @Query("SELECT h FROM Huerto h WHERE h.tamanio.valor > ?1")
    List<Huerto> buscarHuertosGrandes(float valor);

    @Query("SELECT h FROM Huerto h WHERE h.persona.id = :id")
    List<Huerto> buscarPorIdDuenio(Long id);

    @Query("SELECT COUNT(h) FROM Huerto h WHERE h.localizacion = :loc")
    long totalEnCiudad(String loc);

    // 3. CONSULTAS NATIVAS (3)
    @Query(value = "SELECT * FROM huerto WHERE cultivo = ?1 LIMIT 1", nativeQuery = true)
    Huerto elPrimeroDeEseCultivo(String c);

    @Query(value = "SELECT localizacion FROM huerto GROUP BY localizacion", nativeQuery = true)
    List<String> todasLasCiudades();

    @Query(value = "DELETE FROM huerto WHERE persona_id IS NULL", nativeQuery = true)
    @Modifying
    @Transactional
    void limpiarHuertosHuerfanos();
}