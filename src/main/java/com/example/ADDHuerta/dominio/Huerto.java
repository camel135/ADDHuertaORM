package com.example.ADDHuerta.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "huertos")
public class Huerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cultivo;
    private String localizacion;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @Embedded
    private Tamanio tamanio;

    public Huerto() {
    }

    public Huerto(String cultivo, String localizacion, Persona persona, Tamanio tamanio) {
        this.cultivo = cultivo;
        this.localizacion = localizacion;
        this.persona = persona;
        this.tamanio = tamanio;
    }

    public Long getId() {
        return id;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }

    public void setTamanio(Tamanio tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Huerto{" +
                "id=" + id +
                ", cultivo='" + cultivo + '\'' +
                ", localizacion='" + localizacion + '\'' +
                ", tamanio=" + tamanio +
                '}';
    }
}