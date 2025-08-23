package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class EventoDeportivoTest {
    
    private EventoDeportivo evento;
    
    @BeforeEach
    void setUp() {
        evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new Date());
    }
    
    @Test
    void E1_Constructor() {
        // Verificar creación válida del objeto
        assertNotNull(evento);
        assertEquals("E001", evento.getId());
        assertEquals("Barcelona vs Madrid", evento.getNombre());
        assertNotNull(evento.getFechaInicio());
    }
    
    @Test
    void E2_EstadisticasIniciales() {
        // Validar inicialización de estadísticas
        assertNotNull(evento.getEstadisticas());
        assertTrue(evento.getEstadisticas().isEmpty());
    }
    
    @Test
    void E3_Propiedades() {
        // Verificar asignación de propiedades
        assertEquals("E001", evento.getId());
        assertEquals("Barcelona vs Madrid", evento.getNombre());
        assertNotNull(evento.getFechaInicio());
    }
    
    @Test
    void E4_FormatoNombre() {
        // Validar que el nombre tenga contenido
        assertFalse(evento.getNombre().isEmpty());
        assertTrue(evento.getNombre().length() > 0);
    }
    
    @Test
    void E5_FechaNoNula() {
        // Verificar que la fecha sea válida
        assertNotNull(evento.getFechaInicio());
        assertTrue(evento.getFechaInicio() instanceof Date);
    }
}
