package com.sportspredictor.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PronosticoTest {

  private Usuario usuario;
  private EventoDeportivo evento;
  private Pronostico pronostico;

  @BeforeEach
  void setUp() {
    usuario = new Usuario("U123", "Pepe", "pepe@test.com");
    evento = new EventoDeportivo("E777", "Final", new Date());
    pronostico = new Pronostico("P999", usuario, evento, "Visitante");
  }

  @Test
  void P1_ConstructorBasico() {
    assertNotNull(pronostico);
    assertEquals("P999", pronostico.getId());
    assertEquals("PENDIENTE", pronostico.getEstado());
    assertEquals("GENERAL", pronostico.getTipo());
    assertEquals("Visitante", pronostico.getOpcionSeleccionada());

    // Getters “seguros”
    assertEquals("U123", pronostico.getUsuarioId());
    assertEquals("E777", pronostico.getEventoId());
  }

  @Test
  void P2_FechaEsCopiaDefensiva() {
    Date d = pronostico.getFecha();
    assertNotNull(d);
    long original = d.getTime();

    d.setTime(0L); // intento de mutar copia
    assertNotEquals(0L, pronostico.getFecha().getTime());
    assertEquals(original, pronostico.getFecha().getTime());
  }

  @Test
  void P3_CambioEstadoPermitido() {
    pronostico.setEstado("ACERTADO"); // asumiendo que la estrategia lo permite
    assertEquals("ACERTADO", pronostico.getEstado());
  }
}
