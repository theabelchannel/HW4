package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Adaptador de API de fútbol.
 */
public class FutbolAPIAdapter extends AbstractDeporteAPIAdapter {

  // Simulación de API externa de fútbol
  private final FutbolExternalAPI apiExterna = new FutbolExternalAPI();

 
  protected String prefix() {
    return "fut_";
  }

  @Override
  protected List<String> fetchRawEvents() {
    return apiExterna.getMatches();
  }

  @Override
  public EventoDeportivo obtenerEvento(String id) {
    String nombre = apiExterna.getMatch(id);
    return new EventoDeportivo(id, nombre, new Date());
  }

  @Override
  public String obtenerEstadisticas(String eventoId) {
    return apiExterna.getMatchStats(eventoId);
  }

  @Override
  public boolean estaDisponible() {
    return apiExterna.isAvailable();
  }

  /** Clase simulada de API externa. */
  private static class FutbolExternalAPI {
    List<String> getMatches() {
      return Arrays.asList("Barcelona vs Real Madrid", "Manchester United vs Liverpool");
    }

    String getMatch(String id) {
      return "Partido de fútbol";
    }

    String getMatchStats(String id) {
      return "Estadísticas del partido";
    }

    boolean isAvailable() {
      return true;
    }
  }
}
