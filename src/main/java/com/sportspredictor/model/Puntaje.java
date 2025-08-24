/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sportspredictor.model;

/**
 *
 * @author Valeria G
 */
public class Puntaje {
  private int puntos;

  public Puntaje() { this(0); }
  public Puntaje(int puntos) { this.puntos = Math.max(0, puntos); }

  public int getPuntos() { return puntos; }

  public void agregar(int delta) {
    if (delta < 0) return;
    puntos += delta;
  }

  public boolean canjear(int costo) {
    if (costo <= 0 || costo > puntos) return false;
    puntos -= costo;
    return true;
  }
}
