package com.sportspredictor.service;

import com.sportspredictor.model.Pronostico;

public interface IPronosticoState {
    void procesar(Pronostico pronostico);
    boolean puedeCambiarA(String nuevoEstado);
    String getNombreEstado();
}
