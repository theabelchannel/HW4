package com.sportspredictor.service;

import com.sportspredictor.model.Incidencia;

public class IncidenciaService {
    
    private IIncidenciaHandler cadenaIncidencia;
    
    public IncidenciaService() {
        configurarCadena();
    }
    
    private void configurarCadena() {
        // Configurar la cadena: Soporte -> QC -> Administrador
        MiembroSoporteHandler soporte = new MiembroSoporteHandler();
        MiembroQCHandler qc = new MiembroQCHandler();
        AdministradorHandler admin = new AdministradorHandler();
        
        soporte.setSiguiente(qc);
        qc.setSiguiente(admin);
        
        this.cadenaIncidencia = soporte;
    }
    
    public void procesarIncidencia(Incidencia incidencia) {
        System.out.println("Procesando incidencia: " + incidencia.getId());
        cadenaIncidencia.procesar(incidencia);
    }
}
