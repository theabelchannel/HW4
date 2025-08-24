package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PronosticoPendienteStateTest {

    private Pronostico pronostico;

    @BeforeEach
    void setUp() {
        Usuario u = new Usuario("U400", "Lucia", "lucia@test.com");
        EventoDeportivo e = new EventoDeportivo("E400", "NBA Finals", new Date());
        pronostico = new Pronostico("P400", u, e, "Local");
    }

    @Test
    void procesarPronosticoPendiente() {
        PronosticoPendienteState state = new PronosticoPendienteState();
        assertDoesNotThrow(() -> state.procesar(pronostico));
        assertEquals("PENDIENTE", pronostico.getEstado());
    }

    @Test
    void puedeCambiarA_permiteACERTADO() {
        PronosticoPendienteState state = new PronosticoPendienteState();
        assertTrue(state.puedeCambiarA("ACERTADO"));
    }

    @Test
    void puedeCambiarA_permiteFALLIDO() {
        PronosticoPendienteState state = new PronosticoPendienteState();
        assertTrue(state.puedeCambiarA("FALLIDO"));
    }

    @Test
    void puedeCambiarA_noPermiteEN_REVISION() {
        PronosticoPendienteState state = new PronosticoPendienteState();
        assertFalse(state.puedeCambiarA("DESCONOCIDO"));
    }
}
