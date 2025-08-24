package com.sportspredictor.service;

import com.sportspredictor.model.Incidencia;

public class MiembroSoporteHandler extends AbstractIncidenciaHandler {
    
    @Override
    public boolean puedeProcesar(Incidencia incidencia) {
        return !incidencia.isCompleja();
    }
    
    @Override
    protected void procesarIncidencia(Incidencia incidencia) {
        System.out.println("Miembro de soporte procesando incidencia: " + incidencia.getId());
        incidencia.setEstado("RESUELTA");
        System.out.println("Incidencia resuelta por soporte");
    }
}
