package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import com.sportspredictor.repository.IPronosticoRepository;

public class PronosticoService {
    private final IPronosticoRepository pronosticoRepo;
    private final INotifier notifier;

    // Inyección de dependencias a través del constructor
    public PronosticoService(IPronosticoRepository pronosticoRepo, INotifier notifier) {
        this.pronosticoRepo = pronosticoRepo;
        this.notifier = notifier;
    }

    public Pronostico crearPronostico(Usuario usuario, EventoDeportivo evento, String opcion) {
        Pronostico nuevoPronostico = usuario.realizarPronostico(evento, opcion);
        pronosticoRepo.guardar(nuevoPronostico);
        notifier.enviar(usuario, "Tu pronóstico para " + evento.getNombre() + " ha sido registrado.");
        return nuevoPronostico;
    }

    public void evaluarPronosticos(EventoDeportivo evento, String resultadoReal) {
        // Lógica para evaluar todos los pronósticos de un evento finalizado
        System.out.println("Evaluando pronósticos para el evento: " + evento.getNombre());
        // ... aquí se obtendrían los pronósticos del repositorio ...
        // ... y se compararían con el resultadoReal para dar puntos.
    }
} 