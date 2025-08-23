package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FutbolAPIAdapter implements IDeporteAPI {
    
    // Simulación de API externa de fútbol
    private FutbolExternalAPI apiExterna;
    
    public FutbolAPIAdapter() {
        this.apiExterna = new FutbolExternalAPI();
    }
    
    @Override
    public List<EventoDeportivo> obtenerEventos() {
        // Adaptar la respuesta de la API externa al formato interno
        List<String> eventosExternos = apiExterna.getMatches();
        List<EventoDeportivo> eventos = new ArrayList<>();
        
        for (String evento : eventosExternos) {
            eventos.add(new EventoDeportivo("fut_" + evento.hashCode(), evento, new java.util.Date()));
        }
        
        return eventos;
    }
    
    @Override
    public EventoDeportivo obtenerEvento(String id) {
        String eventoExterno = apiExterna.getMatch(id);
        return new EventoDeportivo(id, eventoExterno, new java.util.Date());
    }
    
    @Override
    public String obtenerEstadisticas(String eventoId) {
        return apiExterna.getMatchStats(eventoId);
    }
    
    @Override
    public boolean estaDisponible() {
        return apiExterna.isAvailable();
    }
    
    // Clase simulada de API externa
    private static class FutbolExternalAPI {
        public List<String> getMatches() {
            return Arrays.asList("Barcelona vs Real Madrid", "Manchester United vs Liverpool");
        }
        
        public String getMatch(String id) {
            return "Partido de fútbol";
        }
        
        public String getMatchStats(String id) {
            return "Estadísticas del partido";
        }
        
        public boolean isAvailable() {
            return true;
        }
    }
}
