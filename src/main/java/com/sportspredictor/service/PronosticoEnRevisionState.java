package com.sportspredictor.service;

import com.sportspredictor.model.Pronostico;

public class PronosticoEnRevisionState implements IPronosticoState {
    
    @Override
    public void procesar(Pronostico pronostico) {
        System.out.println("Pronóstico " + pronostico.getId() + " está en revisión por el equipo de QC");
    }
    
    @Override
    public boolean puedeCambiarA(String nuevoEstado) {
        // Puede cambiar a ACERTADO o FALLIDO después de la revisión
        return "ACERTADO".equals(nuevoEstado) || "FALLIDO".equals(nuevoEstado);
    }
    
    @Override
    public String getNombreEstado() {
        return "EN_REVISION";
    }
}
