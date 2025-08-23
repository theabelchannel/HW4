package com.sportspredictor.model;

public class Incidencia {
    private String id;
    private String descripcion;
    private String estado; // NUEVA, EN_PROCESO, ESCALADA, RESUELTA
    private Pronostico pronosticoAfectado;
    private boolean isCompleja;

    public Incidencia(String id, String descripcion, Pronostico pronostico, boolean isCompleja) {
        this.id = id;
        this.descripcion = descripcion;
        this.pronosticoAfectado = pronostico;
        this.estado = "NUEVA";
        this.isCompleja = isCompleja;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        System.out.println("El estado de la incidencia " + this.id + " ha cambiado a: " + estado);
    }

    public boolean isCompleja() {
        return isCompleja;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public Pronostico getPronosticoAfectado() {
        return pronosticoAfectado;
    }
} 