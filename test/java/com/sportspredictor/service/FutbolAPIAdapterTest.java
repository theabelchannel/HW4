package com.sportspredictor.service;

import static org.junit.jupiter.api.Assertions.*;

import com.sportspredictor.model.EventoDeportivo;
import java.util.List;
import org.junit.jupiter.api.Test;

class FutbolAPIAdapterTest {



  @Test
  void obtieneUnEvento_porId() {
    IDeporteAPI api = new FutbolAPIAdapter();
    EventoDeportivo e = api.obtenerEvento("fut_999");

    assertNotNull(e);
    assertEquals("fut_999", e.getId());
    assertNotNull(e.getNombre());
    assertNotNull(e.getFechaInicio());
  }

  @Test
  void obtieneEstadisticas_yDisponibilidad() {
    IDeporteAPI api = new FutbolAPIAdapter();
    assertNotNull(api.obtenerEstadisticas("fut_xyz"));
    assertTrue(api.estaDisponible());
  }
}
