/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sportspredictor.model;

public class UsuarioBuilder {
  private String id;
  private String nombre;
  private String email;

  public UsuarioBuilder id(String id) { this.id = id; return this; }
  public UsuarioBuilder nombre(String n) { this.nombre = n; return this; }
  public UsuarioBuilder email(String e) { this.email = e; return this; }

  public Usuario build() { return new Usuario(id, nombre, email); }
}
