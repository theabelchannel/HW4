package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IncidenciaTest {
    
    private Incidencia incidencia;
    private Pronostico pronostico;
    
    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario("U001", "Juan", "juan@test.com");
        EventoDeportivo evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new java.util.Date());
        pronostico = new Pronostico("P001", usuario, evento, "Local");
        incidencia = new Incidencia("I001", "Error en pronóstico", pronostico, false);
    }
    
    @Test
    void I1_Constructor() {
        // Verificar creación válida del objeto
        assertNotNull(incidencia);
        assertEquals("I001", incidencia.getId());
        assertEquals("Error en pronóstico", incidencia.getDescripcion());
        assertEquals("NUEVA", incidencia.getEstado());
        assertEquals(pronostico, incidencia.getPronosticoAfectado());
        assertFalse(incidencia.isCompleja());
    }
    
    @Test
    void I2_SetEstado() {
        // Validar cambio de estado
        incidencia.setEstado("RESUELTA");
        assertEquals("RESUELTA", incidencia.getEstado());
    }
    
    @Test
    void I3_IncidenciaCompleja() {
        // Verificar marcado de incidencia compleja
        Incidencia incidenciaCompleja = new Incidencia("I002", "Error complejo", pronostico, true);
        assertTrue(incidenciaCompleja.isCompleja());
    }
    
    @Test
    void I4_Propiedades() {
        // Validar asignación de propiedades
        assertEquals("I001", incidencia.getId());
        assertEquals("Error en pronóstico", incidencia.getDescripcion());
        assertEquals(pronostico, incidencia.getPronosticoAfectado());
    }
    
    @Test
    void I5_RelacionConPronostico() {
        // Verificar asociación con pronóstico
        assertNotNull(incidencia.getPronosticoAfectado());
        assertEquals(pronostico, incidencia.getPronosticoAfectado());
        assertEquals("P001", incidencia.getPronosticoAfectado().getId());
    }
}
