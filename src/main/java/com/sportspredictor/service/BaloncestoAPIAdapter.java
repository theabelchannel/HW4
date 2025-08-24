package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Adaptador de API de baloncesto.
 */
public class BaloncestoAPIAdapter extends AbstractDeporteAPIAdapter {

  // Simulación de API externa de baloncesto
  private final BaloncestoExternalAPI apiExterna = new BaloncestoExternalAPI();

  protected String prefix() {
    return "bal_";
  }

  @Override
  protected List<String> fetchRawEvents() {
    return apiExterna.getGames();
  }

  @Override
  public EventoDeportivo obtenerEvento(String id) {
    String nombre = apiExterna.getGame(id);
    return new EventoDeportivo(id, nombre, new Date());
  }

  @Override
  public String obtenerEstadisticas(String eventoId) {
    return apiExterna.getGameStats(eventoId);
  }

  @Override
  public boolean estaDisponible() {
    return apiExterna.isAvailable();
  }

  /** Clase simulada de API externa. */
  private static class BaloncestoExternalAPI {
    List<String> getGames() {
      return Arrays.asList("Lakers vs Warriors", "Celtics vs Heat");
    }

    String getGame(String id) {
      return "Partido de baloncesto";
    }

    String getGameStats(String id) {
      return "Estadísticas del partido";
    }

    boolean isAvailable() {
      return true;
    }
  }
}
