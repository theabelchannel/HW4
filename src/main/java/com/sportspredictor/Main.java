package com.sportspredictor;

import com.sportspredictor.model.*;
import com.sportspredictor.service.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA SPORTSPREDICTOR ===\n");
        
        // Inicialización del sistema
        INotifierFactory notifierFactory = new NotifierFactory();
        IPronosticoFactory pronosticoFactory = new PronosticoFactory();
        IDeporteAPI futbolAPI = new FutbolAPIAdapter();
        IDeporteAPI baloncestoAPI = new BaloncestoAPIAdapter();
        IncidenciaService incidenciaService = new IncidenciaService();
        
        // Crear usuarios del sistema
        Usuario usuario1 = new Usuario("user001", "Juan Pérez", "juan@email.com");
        Usuario usuario2 = new Usuario("user002", "María García", "maria@email.com");
        Usuario admin = new Usuario("admin001", "Admin Sistema", "admin@sportspredictor.com");
        
        // Simular eventos deportivos disponibles
        System.out.println("EVENTOS DEPORTIVOS DISPONIBLES:");
        List<EventoDeportivo> eventosFutbol = futbolAPI.obtenerEventos();
        List<EventoDeportivo> eventosBaloncesto = baloncestoAPI.obtenerEventos();
        
        for (EventoDeportivo evento : eventosFutbol) {
            System.out.println("FUTBOL: " + evento.getNombre() + " - " + evento.getFechaInicio());
        }
        for (EventoDeportivo evento : eventosBaloncesto) {
            System.out.println("BALONCESTO: " + evento.getNombre() + " - " + evento.getFechaInicio());
        }
        
        // Usuarios realizan pronósticos
        System.out.println("\nUSUARIOS REALIZANDO PRONOSTICOS:");
        
        // Usuario 1 hace pronóstico de resultado
        EventoDeportivo eventoFutbol = eventosFutbol.get(0);
        Pronostico pronostico1 = pronosticoFactory.crearPronosticoResultado(
            usuario1, eventoFutbol, "Victoria Local"
        );
        System.out.println("OK " + usuario1.getNombreUsuario() + " pronosticó: " + pronostico1.getOpcionSeleccionada());
        
        // Usuario 2 hace pronóstico de marcador
        EventoDeportivo eventoBaloncesto = eventosBaloncesto.get(0);
        Pronostico pronostico2 = pronosticoFactory.crearPronosticoMarcador(
            usuario2, eventoBaloncesto, "85-78"
        );
        System.out.println("OK " + usuario2.getNombreUsuario() + " pronosticó: " + pronostico2.getOpcionSeleccionada());
        
        // Simular procesamiento de eventos y actualización de estados
        System.out.println("\nPROCESANDO RESULTADOS DE EVENTOS:");
        
        // Evento de fútbol finaliza
        System.out.println("FUTBOL: " + eventoFutbol.getNombre() + " ha finalizado");
        pronostico1.setEstado("ACERTADO");
        pronostico1.procesarEstado();
        usuario1.setPuntos(usuario1.getPuntos() + 10);
        System.out.println("EXITO " + usuario1.getNombreUsuario() + " acertó! +10 puntos. Total: " + usuario1.getPuntos());
        
        // Evento de baloncesto finaliza
        System.out.println("BALONCESTO: " + eventoBaloncesto.getNombre() + " ha finalizado");
        pronostico2.setEstado("FALLIDO");
        pronostico2.procesarEstado();
        System.out.println("ERROR " + usuario2.getNombreUsuario() + " no acertó. Puntos: " + usuario2.getPuntos());
        
        // Envío de notificaciones
        System.out.println("\nENVIANDO NOTIFICACIONES:");
        
        INotifier emailNotifier = notifierFactory.crearEmailNotifier();
        INotifier smsNotifier = notifierFactory.crearSMSNotifier();
        INotifier pushNotifier = notifierFactory.crearPushNotifier();
        
        emailNotifier.enviar(usuario1, "¡Felicidades! Tu pronóstico fue correcto. +10 puntos.");
        smsNotifier.enviar(usuario1, "Tu pronóstico fue correcto! +10 puntos.");
        pushNotifier.enviar(usuario1, "¡Victoria! Pronóstico acertado.");
        
        emailNotifier.enviar(usuario2, "Tu pronóstico no fue correcto esta vez. ¡Sigue intentando!");
        
        // Simular incidente reportado
        System.out.println("\nPROCESANDO INCIDENTE:");
        Incidencia incidencia = new Incidencia("INC001", "Discrepancia en resultado de partido", pronostico1, false);
        
        System.out.println("INCIDENTE reportado: " + incidencia.getId());
        incidenciaService.procesarIncidencia(incidencia);
        
        // Mostrar estadísticas del sistema
        System.out.println("\nESTADISTICAS DEL SISTEMA:");
        System.out.println("Usuarios registrados: 3");
        System.out.println("Pronósticos realizados: 2");
        System.out.println("Pronósticos acertados: 1");
        System.out.println("Pronósticos fallidos: 1");
        System.out.println("Incidentes reportados: 1");
        
        System.out.println("\n=== SISTEMA FUNCIONANDO CORRECTAMENTE ===");
    }
} 