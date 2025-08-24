package com.sportspredictor.model;

/**
 * Incidencia reportada sobre un pronóstico.
 * Refactor:
 *  - No almacena objetos mutables externos (Pronostico) para evitar EI/EI2.
 *  - Guarda solo una instantánea (ids/datos) del pronóstico.
 *  - Campos inmutables cuando aplica.
 */
public class Incidencia {

  private final String id;
  private final String descripcion;
  private String estado; // NUEVA, EN_PROCESO, ESCALADA, RESUELTA
  private final boolean compleja;

  // Snapshot del pronóstico afectado (sin exponer el objeto mutable)
  private final String pronosticoId;
  private final String usuarioId;
  private final String eventoId;
  private final String opcionSeleccionada;

  public Incidencia(String id, String descripcion, Pronostico pronostico, boolean esCompleja) {
    this.id = id;
    this.descripcion = descripcion;
    this.estado = "NUEVA";
    this.compleja = esCompleja;

    // Tomamos solo los datos necesarios del pronóstico (no guardamos la referencia)
    this.pronosticoId = pronostico.getId();
    this.usuarioId = pronostico.getUsuarioId();       // métodos "seguros" del Pronostico refactorizado
    this.eventoId = pronostico.getEventoId();
    this.opcionSeleccionada = pronostico.getOpcionSeleccionada();
  }

  // Getters

  public String getId() {
    return id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getEstado() {
    return estado;
  }

  public boolean isCompleja() {
    return compleja;
  }

  /** Id del pronóstico afectado. */
  public String getPronosticoId() {
    return pronosticoId;
  }

  /** Id del usuario dueño del pronóstico afectado. */
  public String getUsuarioId() {
    return usuarioId;
  }

  /** Id del evento asociado al pronóstico afectado. */
  public String getEventoId() {
    return eventoId;
  }

  /** Opción seleccionada originalmente en el pronóstico. */
  public String getOpcionSeleccionada() {
    return opcionSeleccionada;
  }

  // Comportamiento

  public void setEstado(String nuevoEstado) {
    this.estado = nuevoEstado;
    System.out.println("El estado de la incidencia " + id + " ha cambiado a: " + nuevoEstado);
  }
}
