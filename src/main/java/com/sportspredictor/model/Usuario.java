package com.sportspredictor.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Cuenta {
    private int puntos;
    private List<Pronostico> pronosticos;

    public Usuario(String id, String nombreUsuario, String email) {
        super(id, nombreUsuario, email);
        this.puntos = 0;
        this.pronosticos = new ArrayList<>();
    }

    public Pronostico realizarPronostico(EventoDeportivo evento, String opcion) {
        System.out.println(nombreUsuario + " está realizando un pronóstico para el evento " + evento.getNombre());
        Pronostico p = new Pronostico("p" + pronosticos.size() + 1, this, evento, opcion);
        this.pronosticos.add(p);
        return p;
    }

    public boolean canjearPuntos(int puntosNecesarios) {
        if (this.puntos >= puntosNecesarios) {
            this.puntos -= puntosNecesarios;
            System.out.println("Canje exitoso. Puntos restantes: " + this.puntos);
            return true;
        }
        System.out.println("Puntos insuficientes para el canje.");
        return false;
    }

    public List<Pronostico> consultarHistorial() {
        return this.pronosticos;
    }

    // Getters y Setters
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
} 