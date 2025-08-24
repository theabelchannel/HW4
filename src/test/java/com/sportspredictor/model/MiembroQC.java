package com.sportspredictor.model;

public class MiembroQC extends MiembroSoporte {

    public MiembroQC(String id, String nombreUsuario, String email) {
        super(id, nombreUsuario, email);
    }

    public void revisarIncidenciaDetallada(Incidencia incidencia) {
        System.out.println("El miembro de QC " + nombreUsuario + " está realizando una revisión detallada de la incidencia: " + incidencia.getId());
        incidencia.setEstado("RESUELTA"); // Decisión final de QC
        System.out.println("La incidencia " + incidencia.getId() + " ha sido resuelta por el equipo de Calidad.");
    }
} 