package com.sportspredictor.service;

import com.sportspredictor.model.Incidencia;

public interface IIncidenciaHandler {
    void setSiguiente(IIncidenciaHandler siguiente);
    void procesar(Incidencia incidencia);
    boolean puedeProcesar(Incidencia incidencia);
}
