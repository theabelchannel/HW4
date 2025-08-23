package com.sportspredictor.service;

import com.sportspredictor.model.Pronostico;

public class PronosticoAcertadoState implements IPronosticoState {
    
    @Override
    public void procesar(Pronostico pronostico) {
        System.out.println("Pronóstico " + pronostico.getId() + " fue acertado - asignando puntos");
        // Aquí se asignarían puntos al usuario
    }
    
    @Override
    public boolean puedeCambiarA(String nuevoEstado) {
        // Una vez acertado, no puede cambiar de estado
        return false;
    }
    
    @Override
    public String getNombreEstado() {
        return "ACERTADO";
    }
}
