package com.sportspredictor.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Valeria G
 * Ahora la gestión de puntos se delega a la clase Puntaje (Extract Class).
 */
public class Usuario extends Cuenta {

  private final Puntaje puntaje;
  private final List<Pronostico> pronosticos;

  public Usuario(String id, String nombreUsuario, String email) {
    super(id, nombreUsuario, email);
    this.puntaje = new Puntaje(); // inicialmente en 0
    this.pronosticos = new ArrayList<>();
  }

  /** Permite al usuario realizar un pronóstico sobre un evento deportivo. */
  public Pronostico realizarPronostico(EventoDeportivo evento, String opcion) {
    System.out.println(getNombreUsuario()
        + " está realizando un pronóstico para el evento " + evento.getNombre());
    Pronostico p =
        new Pronostico("P" + (pronosticos.size() + 1), this, evento, opcion);
    pronosticos.add(p);
    return p;
  }

  /** Intenta canjear puntos. Devuelve true si el canje fue exitoso. */
  public boolean canjearPuntos(int puntosNecesarios) {
    boolean exito = puntaje.canjear(puntosNecesarios);
    if (exito) {
      System.out.println("Canje exitoso. Puntos restantes: " + puntaje.getPuntos());
    } else {
      System.out.println("Puntos insuficientes para el canje.");
    }
    return exito;
  }

  /** Consulta historial de pronósticos (lista inmutable). */
  public List<Pronostico> consultarHistorial() {
    return Collections.unmodifiableList(new ArrayList<>(pronosticos));
  }

  // Métodos de puntos delegados a Puntaje
  public int getPuntos() {
    return puntaje.getPuntos();
  }

  public void agregarPuntos(int delta) {
    puntaje.agregar(delta);
  }
}
