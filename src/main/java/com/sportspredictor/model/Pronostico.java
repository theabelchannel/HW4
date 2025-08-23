package com.sportspredictor.model;

import java.util.Date;
import com.sportspredictor.service.IPronosticoState;
import com.sportspredictor.service.PronosticoPendienteState;

public class Pronostico {
    private String id;
    private Date fecha;
    private String estado; // PENDIENTE, ACERTADO, FALLIDO, EN_REVISION
    private String tipo; // RESULTADO, MARCADOR, RENDIMIENTO
    private Usuario usuario;
    private EventoDeportivo evento;
    private String opcionSeleccionada;
    private IPronosticoState estadoActual;

    public Pronostico(String id, Usuario usuario, EventoDeportivo evento, String opcionSeleccionada) {
        this.id = id;
        this.fecha = new Date(); // Fecha de creación
        this.estado = "PENDIENTE";
        this.tipo = "GENERAL";
        this.usuario = usuario;
        this.evento = evento;
        this.opcionSeleccionada = opcionSeleccionada;
        this.estadoActual = new PronosticoPendienteState();
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estadoActual.puedeCambiarA(estado)) {
            this.estado = estado;
            System.out.println("El estado del pronóstico " + this.id + " ha cambiado a: " + estado);
        } else {
            System.out.println("No se puede cambiar de " + this.estado + " a " + estado);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public EventoDeportivo getEvento() {
        return evento;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getOpcionSeleccionada() {
        return opcionSeleccionada;
    }
    
    public void procesarEstado() {
        estadoActual.procesar(this);
    }
} 