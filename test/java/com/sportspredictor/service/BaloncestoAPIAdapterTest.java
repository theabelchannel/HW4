package com.sportspredictor.service;

import static org.junit.jupiter.api.Assertions.*;

import com.sportspredictor.model.EventoDeportivo;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaloncestoAPIAdapterTest {



  @Test
  void obtieneUnEvento_porId() {
    IDeporteAPI api = new BaloncestoAPIAdapter();
    EventoDeportivo e = api.obtenerEvento("bal_123");

    assertNotNull(e);
    assertEquals("bal_123", e.getId());
    assertNotNull(e.getNombre());
    assertNotNull(e.getFechaInicio());
  }

  @Test
  void obtieneEstadisticas_yDisponibilidad() {
    IDeporteAPI api = new BaloncestoAPIAdapter();
    assertNotNull(api.obtenerEstadisticas("bal_abc"));
    assertTrue(api.estaDisponible());
  }
}
