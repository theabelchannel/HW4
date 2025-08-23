package com.sportspredictor.service;

import com.sportspredictor.model.Incidencia;

public class AdministradorHandler extends AbstractIncidenciaHandler {
    
    @Override
    public boolean puedeProcesar(Incidencia incidencia) {
        // Los administradores pueden procesar cualquier incidencia
        return true;
    }
    
    @Override
    protected void procesarIncidencia(Incidencia incidencia) {
        System.out.println("Administrador procesando incidencia: " + incidencia.getId());
        incidencia.setEstado("RESUELTA");
        System.out.println("Incidencia resuelta por administrador");
    }
}
