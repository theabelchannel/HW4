package com.sportspredictor.model;

public class Administrador extends Cuenta {

    public Administrador(String id, String nombreUsuario, String email) {
        super(id, nombreUsuario, email);
    }

    public void gestionarOpciones(EventoDeportivo evento, String nuevasOpciones) {
        System.out.println("El administrador " + nombreUsuario + " está gestionando opciones para el evento: " + evento.getNombre());
        // Lógica para modificar opciones de pronóstico de un evento
    }

    public void gestionarReglas(String nuevasReglas) {
        System.out.println("El administrador " + nombreUsuario + " está gestionando las reglas de puntuación.");
        // Lógica para actualizar las reglas del sistema
    }
} 