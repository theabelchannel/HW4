package com.sportspredictor.service;

import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import com.sportspredictor.model.EventoDeportivo;

public interface IPronosticoFactory {
    Pronostico crearPronosticoResultado(Usuario usuario, EventoDeportivo evento, String resultado);
    Pronostico crearPronosticoMarcador(Usuario usuario, EventoDeportivo evento, String marcador);
    Pronostico crearPronosticoRendimiento(Usuario usuario, EventoDeportivo evento, String rendimiento);
}
