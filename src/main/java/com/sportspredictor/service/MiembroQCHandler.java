package com.sportspredictor.service;

import com.sportspredictor.model.Incidencia;

public class MiembroQCHandler extends AbstractIncidenciaHandler {
    
    @Override
    public boolean puedeProcesar(Incidencia incidencia) {
        // Los miembros de QC pueden procesar incidencias complejas
        return incidencia.isCompleja();
    }
    
    @Override
    protected void procesarIncidencia(Incidencia incidencia) {
        System.out.println("Miembro de QC procesando incidencia: " + incidencia.getId());
        incidencia.setEstado("EN_PROCESO");
        System.out.println("Incidencia en proceso por QC");
        
        // Simular resolución después de revisión
        if (Math.random() > 0.3) { // 70% de probabilidad de resolver
            incidencia.setEstado("RESUELTA");
            System.out.println("Incidencia resuelta por QC");
        } else {
            // Si no puede resolver, pasa al siguiente en la cadena
            if (siguiente != null) {
                siguiente.procesar(incidencia);
            }
        }
    }
}
