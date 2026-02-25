package com.example.ADDHuerta.dominio;

import jakarta.persistence.Embeddable;

@Embeddable
public class Tamanio {

    private float valor;
    private String unidad;

    public Tamanio() {}

    public Tamanio(float valor, String unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public float getValor() { return valor; }
    public void setValor(float valor) { this.valor = valor; }
    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    @Override
    public String toString() {
        return valor + " " + unidad;
    }
}