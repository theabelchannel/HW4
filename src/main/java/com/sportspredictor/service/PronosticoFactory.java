package com.sportspredictor.service;

import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import com.sportspredictor.model.EventoDeportivo;
import java.util.UUID;

public class PronosticoFactory implements IPronosticoFactory {
    
    @Override
    public Pronostico crearPronosticoResultado(Usuario usuario, EventoDeportivo evento, String resultado) {
        String id = UUID.randomUUID().toString();
        Pronostico pronostico = new Pronostico(id, usuario, evento, resultado);
        pronostico.setTipo("RESULTADO");
        return pronostico;
    }
    
    @Override
    public Pronostico crearPronosticoMarcador(Usuario usuario, EventoDeportivo evento, String marcador) {
        String id = UUID.randomUUID().toString();
        Pronostico pronostico = new Pronostico(id, usuario, evento, marcador);
        pronostico.setTipo("MARCADOR");
        return pronostico;
    }
    
    @Override
    public Pronostico crearPronosticoRendimiento(Usuario usuario, EventoDeportivo evento, String rendimiento) {
        String id = UUID.randomUUID().toString();
        Pronostico pronostico = new Pronostico(id, usuario, evento, rendimiento);
        pronostico.setTipo("RENDIMIENTO");
        return pronostico;
    }
}
