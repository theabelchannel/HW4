package com.sportspredictor.model;

public class MiembroSoporte extends Cuenta {

    public MiembroSoporte(String id, String nombreUsuario, String email) {
        super(id, nombreUsuario, email);
    }

    public void gestionarIncidencia(Incidencia incidencia) {
        System.out.println("El miembro de soporte " + nombreUsuario + " está gestionando la incidencia: " + incidencia.getId());
        if (incidencia.isCompleja()) {
            this.escalarIncidencia(incidencia);
        } else {
            incidencia.setEstado("RESUELTA");
            System.out.println("La incidencia " + incidencia.getId() + " ha sido resuelta.");
        }
    }

    protected void escalarIncidencia(Incidencia incidencia) {
        System.out.println("La incidencia " + incidencia.getId() + " es compleja y será escalada.");
        MiembroQC miembroQC = new MiembroQC("qc01", "QualityControlUser", "qc@sportspredictor.com");
        miembroQC.revisarIncidenciaDetallada(incidencia);
    }
} 