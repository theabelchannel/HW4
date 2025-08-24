package com.sportspredictor.service;

import com.sportspredictor.model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class EmailNotifierTest {

    @Test
    void enviarEmail_noLanzaExcepcion() {
        Usuario u = new Usuario("U100", "Juan", "juan@test.com");
        EmailNotifier notifier = new EmailNotifier();

        assertDoesNotThrow(() -> notifier.enviar(u, "Mensaje de prueba"));
    }
}
