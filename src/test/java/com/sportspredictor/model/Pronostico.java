package com.sportspredictor.model;

import com.sportspredictor.service.IPronosticoState;
import com.sportspredictor.service.PronosticoPendienteState;
import java.util.Date;
import java.util.Objects;

/**
 * Representa un pronóstico realizado por un usuario sobre un evento deportivo.
 * Refactor:
 *  - Copias defensivas en Date (evita exposición de estado interno).
 *  - Evita exponer Usuario/Evento completos; se ofrecen getters de datos básicos.
 *  - Campos inmutables cuando aplica (id, fecha, usuario, evento, opción).
 */
public class Pronostico {

  private final String id;
  private final Date fecha;                 // creación; defensiva en getter
  private String estado;                    // PENDIENTE, ACERTADO, FALLIDO, EN_REVISION
  private String tipo;                      // RESULTADO, MARCADOR, RENDIMIENTO, GENERAL
  private final Usuario usuario;            // no exponer directamente
  private final EventoDeportivo evento;     // no exponer directamente
  private final String opcionSeleccionada;
  private IPronosticoState estadoActual;

  public Pronostico(String id, Usuario usuario, EventoDeportivo evento, String opcionSeleccionada) {
    this.id = Objects.requireNonNull(id, "id");
    this.fecha = new Date(); // instantánea de creación
    this.estado = "PENDIENTE";
    this.tipo = "GENERAL";
    this.usuario = Objects.requireNonNull(usuario, "usuario");
    this.evento = Objects.requireNonNull(evento, "evento");
    this.opcionSeleccionada = Objects.requireNonNull(opcionSeleccionada, "opcionSeleccionada");
    this.estadoActual = new PronosticoPendienteState();
  }

  // ===== Getters seguros / de solo lectura =====

  public String getId() {
    return id;
  }

  /** Fecha de creación del pronóstico (copia defensiva). */
  public Date getFecha() {
    return new Date(fecha.getTime());
  }

  public String getEstado() {
    return estado;
  }

  public String getTipo() {
    return tipo;
  }

  public String getOpcionSeleccionada() {
    return opcionSeleccionada;
  }

  // === Datos del usuario sin exponer el objeto completo (evita EI/EI2) ===
  public String getUsuarioId() {
    return usuario.getId();
  }

  public String getUsuarioNombre() {
    return usuario.getNombreUsuario();
  }

  public String getUsuarioEmail() {
    return usuario.getEmail();
  }

  // === Datos del evento sin exponer el objeto completo (evita EI/EI2) ===
  public String getEventoId() {
    return evento.getId();
  }

  public String getEventoNombre() {
    return evento.getNombre();
  }

  public Date getEventoFechaInicio() {
    return evento.getFechaInicio(); // EventoDeportivo ya devuelve copia defensiva
  }

  // ===== Comportamiento =====

  /**
   * Cambia el estado si la estrategia lo permite.
   * Mantiene el log en consola (como en tu versión original).
   */
  public void setEstado(String nuevoEstado) {
    if (estadoActual.puedeCambiarA(nuevoEstado)) {
      this.estado = nuevoEstado;
      System.out.println("El estado del pronóstico " + id + " ha cambiado a: " + nuevoEstado);
    } else {
      System.out.println("No se puede cambiar de " + estado + " a " + nuevoEstado);
    }
  }

  /** Permite ajustar la estrategia de estado externamente si hace falta. */
  public void setEstadoActual(IPronosticoState nuevoEstado) {
    this.estadoActual = Objects.requireNonNull(nuevoEstado, "estadoActual");
  }

  public void setTipo(String tipo) {
    this.tipo = Objects.requireNonNull(tipo, "tipo");
  }

  /** Dispara el procesamiento en la estrategia actual. */
  public void procesarEstado() {
    estadoActual.procesar(this);
  }
}
