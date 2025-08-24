package com.sportspredictor.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa un evento deportivo con fecha de inicio y estadísticas asociadas.
 * Refactor: se aplican copias defensivas para evitar exponer estado interno.
 */
public class EventoDeportivo {

  private final String id;
  private final String nombre;
  private final Date fechaInicio;
  private final Map<String, String> estadisticas;

  public EventoDeportivo(String id, String nombre, Date fechaInicio) {
    this.id = id;
    this.nombre = nombre;
    // Copia defensiva para evitar mutabilidad externa
    this.fechaInicio = new Date(fechaInicio.getTime());
    this.estadisticas = new HashMap<>();
  }

  // Getters seguros

  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  /**
   * Devuelve una copia defensiva de la fecha de inicio.
   */
  public Date getFechaInicio() {
    return new Date(fechaInicio.getTime());
  }

  /**
   * Devuelve un mapa inmutable con las estadísticas.
   */
  public Map<String, String> getEstadisticas() {
    return Collections.unmodifiableMap(new HashMap<>(estadisticas));
  }

  /**
   * Método controlado para añadir estadísticas al evento.
   */
  public void agregarEstadistica(String clave, String valor) {
    estadisticas.put(clave, valor);
  }
}
