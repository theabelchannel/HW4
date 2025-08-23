package com.sportspredictor.service;

import com.sportspredictor.model.Pronostico;

public class PronosticoPendienteState implements IPronosticoState {
    
    @Override
    public void procesar(Pronostico pronostico) {
        System.out.println("Pronóstico " + pronostico.getId() + " está pendiente de resolución");
    }
    
    @Override
    public boolean puedeCambiarA(String nuevoEstado) {
        return "ACERTADO".equals(nuevoEstado) || 
               "FALLIDO".equals(nuevoEstado) || 
               "EN_REVISION".equals(nuevoEstado);
    }
    
    @Override
    public String getNombreEstado() {
        return "PENDIENTE";
    }
}
