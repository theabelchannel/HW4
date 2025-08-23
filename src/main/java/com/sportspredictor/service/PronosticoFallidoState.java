package com.sportspredictor.service;

import com.sportspredictor.model.Pronostico;

public class PronosticoFallidoState implements IPronosticoState {
    
    @Override
    public void procesar(Pronostico pronostico) {
        System.out.println("Pronóstico " + pronostico.getId() + " fue fallido - no se asignan puntos");
    }
    
    @Override
    public boolean puedeCambiarA(String nuevoEstado) {
        // Solo puede cambiar a EN_REVISION si hay una disputa
        return "EN_REVISION".equals(nuevoEstado);
    }
    
    @Override
    public String getNombreEstado() {
        return "FALLIDO";
    }
}
