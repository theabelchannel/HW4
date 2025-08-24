package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PronosticoFallidoStateTest {

    private Pronostico pronostico;

    @BeforeEach
    void setUp() {
        Usuario u = new Usuario("U300", "Pedro", "pedro@test.com");
        EventoDeportivo e = new EventoDeportivo("E300", "Super Bowl", new Date());
        pronostico = new Pronostico("P300", u, e, "Visitante");
    }

  

    @Test
    void puedeCambiarA_noPermiteACERTADO() {
        PronosticoFallidoState state = new PronosticoFallidoState();
        boolean puede = state.puedeCambiarA("ACERTADO");
        assertEquals(false, puede);
    }
}
