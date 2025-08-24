package com.sportspredictor.service;

import com.sportspredictor.model.EventoDeportivo;
import com.sportspredictor.model.Incidencia;
import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para IncidenciaService usando la cadena interna:
 * MiembroSoporteHandler -> MiembroQCHandler -> AdministradorHandler
 */
class IncidenciaServiceTest {

  @Test
  void procesaIncidencia_simple_quedaResuelta() {
    // arrange
    Usuario u = new Usuario("U100", "User", "u@test.com");
    EventoDeportivo e = new EventoDeportivo("E100", "Partido", new Date());
    Pronostico p = new Pronostico("P100", u, e, "Local");
    Incidencia simple = new Incidencia("I100", "Incidencia simple", p, false);

    IncidenciaService svc = new IncidenciaService();

    // act + assert
    assertDoesNotThrow(() -> svc.procesarIncidencia(simple));
    // La cadena debe resolver la incidencia
    assertEquals("RESUELTA", simple.getEstado());
  }


  @Test
  void procesaVariasVeces_noLanza_yDejaEstadoResuelto() {
    Usuario u = new Usuario("U102", "User", "u@test.com");
    EventoDeportivo e = new EventoDeportivo("E102", "Partido", new Date());
    Pronostico p = new Pronostico("P102", u, e, "Local");
    Incidencia inc = new Incidencia("I102", "Repetida", p, false);

    IncidenciaService svc = new IncidenciaService();

    assertDoesNotThrow(() -> {
      svc.procesarIncidencia(inc);
      svc.procesarIncidencia(inc); // idempotencia básica: no debe romper
    });
    assertEquals("RESUELTA", inc.getEstado());
  }
}
