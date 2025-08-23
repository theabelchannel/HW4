package com.sportspredictor.service;

import com.sportspredictor.model.Incidencia;

public abstract class AbstractIncidenciaHandler implements IIncidenciaHandler {
    
    protected IIncidenciaHandler siguiente;
    
    @Override
    public void setSiguiente(IIncidenciaHandler siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public void procesar(Incidencia incidencia) {
        if (puedeProcesar(incidencia)) {
            procesarIncidencia(incidencia);
        } else if (siguiente != null) {
            siguiente.procesar(incidencia);
        } else {
            System.out.println("Ningún handler puede procesar la incidencia: " + incidencia.getId());
        }
    }
    
    protected abstract void procesarIncidencia(Incidencia incidencia);
}
