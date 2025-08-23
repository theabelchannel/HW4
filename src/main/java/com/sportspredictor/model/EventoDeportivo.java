package com.sportspredictor.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EventoDeportivo {
    private String id;
    private String nombre;
    private Date fechaInicio;
    private Map<String, String> estadisticas;

    public EventoDeportivo(String id, String nombre, Date fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estadisticas = new HashMap<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Map<String, String> getEstadisticas() {
        return estadisticas;
    }
} 