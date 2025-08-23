package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PronosticoTest {
    
    private Pronostico pronostico;
    private Usuario usuario;
    private EventoDeportivo evento;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("U001", "Juan", "juan@test.com");
        evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new java.util.Date());
        pronostico = new Pronostico("P001", usuario, evento, "Local");
    }
    
    @Test
    void P1_Constructor() {
        // Verificar creación válida del objeto
        assertNotNull(pronostico);
        assertEquals("P001", pronostico.getId());
        assertEquals(usuario, pronostico.getUsuario());
        assertEquals(evento, pronostico.getEvento());
        assertEquals("Local", pronostico.getOpcionSeleccionada());
    }
    
    @Test
    void P2_SetEstado() {
        // Validar cambio de estado
        pronostico.setEstado("ACERTADO");
        assertEquals("ACERTADO", pronostico.getEstado());
    }
    
    @Test
    void P3_SetTipo() {
        // Verificar cambio de tipo
        pronostico.setTipo("RESULTADO");
        assertEquals("RESULTADO", pronostico.getTipo());
    }
    
    @Test
    void P4_ProcesarEstado() {
        // Validar procesamiento del estado
        assertDoesNotThrow(() -> pronostico.procesarEstado());
    }
    
    @Test
    void P5_Relaciones() {
        // Verificar asociaciones del pronóstico
        assertEquals(usuario, pronostico.getUsuario());
        assertEquals(evento, pronostico.getEvento());
        assertNotNull(pronostico.getUsuario());
        assertNotNull(pronostico.getEvento());
    }
}
