package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiembroQCTest {
    
    private MiembroQC miembroQC;
    private Incidencia incidencia;
    
    @BeforeEach
    void setUp() {
        miembroQC = new MiembroQC("MQ001", "QC", "qc@test.com");
        Usuario usuario = new Usuario("U001", "Juan", "juan@test.com");
        EventoDeportivo evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new java.util.Date());
        Pronostico pronostico = new Pronostico("P001", usuario, evento, "Local");
        incidencia = new Incidencia("I001", "Error en pronóstico", pronostico, false);
    }
    
    @Test
    void MQ1_Constructor() {
        // Verificar creación válida del objeto
        assertNotNull(miembroQC);
        assertEquals("MQ001", miembroQC.getId());
        assertEquals("QC", miembroQC.getNombreUsuario());
        assertEquals("qc@test.com", miembroQC.getEmail());
    }
    
    @Test
    void MQ2_RevisarIncidenciaDetallada() {
        // Validar revisión detallada de incidencia
        assertDoesNotThrow(() -> miembroQC.revisarIncidenciaDetallada(incidencia));
    }
    
    @Test
    void MQ3_Herencia() {
        // Verificar herencia correcta de MiembroSoporte
        assertTrue(miembroQC instanceof MiembroSoporte);
        assertTrue(miembroQC instanceof Cuenta);
    }
    
    @Test
    void MQ4_Login() {
        // Validar autenticación del miembro QC
        boolean resultado = miembroQC.login("qc@test.com", "123");
        assertTrue(resultado);
    }
    
    @Test
    void MQ5_FormatoID() {
        // Verificar formato válido del ID
        String id = miembroQC.getId();
        assertNotNull(id);
        assertTrue(id.startsWith("MQ"));
        assertTrue(id.length() > 2);
    }
}
