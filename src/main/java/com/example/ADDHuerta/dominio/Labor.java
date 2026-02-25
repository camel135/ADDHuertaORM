package com.example.ADDHuerta.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "labores")
public class Labor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(name = "fecha_limite")
    private String fechaLimite;

    @ManyToOne
    @JoinColumn(name = "huerto_id")
    private Huerto huerto;

    public Labor() {
    }

    public Labor(String descripcion, String fechaLimite, Huerto huerto) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.huerto = huerto;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Huerto getHuerto() {
        return huerto;
    }

    public void setHuerto(Huerto huerto) {
        this.huerto = huerto;
    }

    @Override
    public String toString() {
        return "Labor{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fechaLimite='" + fechaLimite + '\'' +
                '}';
    }
}