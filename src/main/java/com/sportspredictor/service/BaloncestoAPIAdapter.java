package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BaloncestoAPIAdapter implements IDeporteAPI {
    
    // Simulación de API externa de baloncesto
    private BaloncestoExternalAPI apiExterna;
    
    public BaloncestoAPIAdapter() {
        this.apiExterna = new BaloncestoExternalAPI();
    }
    
    @Override
    public List<EventoDeportivo> obtenerEventos() {
        // Adaptar la respuesta de la API externa al formato interno
        List<String> eventosExternos = apiExterna.getGames();
        List<EventoDeportivo> eventos = new ArrayList<>();
        
        for (String evento : eventosExternos) {
            eventos.add(new EventoDeportivo("bal_" + evento.hashCode(), evento, new java.util.Date()));
        }
        
        return eventos;
    }
    
    @Override
    public EventoDeportivo obtenerEvento(String id) {
        String eventoExterno = apiExterna.getGame(id);
        return new EventoDeportivo(id, eventoExterno, new java.util.Date());
    }
    
    @Override
    public String obtenerEstadisticas(String eventoId) {
        return apiExterna.getGameStats(eventoId);
    }
    
    @Override
    public boolean estaDisponible() {
        return apiExterna.isAvailable();
    }
    
    // Clase simulada de API externa
    private static class BaloncestoExternalAPI {
        public List<String> getGames() {
            return Arrays.asList("Lakers vs Warriors", "Celtics vs Heat");
        }
        
        public String getGame(String id) {
            return "Partido de baloncesto";
        }
        
        public String getGameStats(String id) {
            return "Estadísticas del partido";
        }
        
        public boolean isAvailable() {
            return true;
        }
    }
}
