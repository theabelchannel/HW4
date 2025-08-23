package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import java.util.List;

public interface IDeporteAPI {
    List<EventoDeportivo> obtenerEventos();
    EventoDeportivo obtenerEvento(String id);
    String obtenerEstadisticas(String eventoId);
    boolean estaDisponible();
}
