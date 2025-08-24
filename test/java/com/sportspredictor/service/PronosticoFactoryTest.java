package com.sportspredictor.service;

import static org.junit.jupiter.api.Assertions.*;

import com.sportspredictor.model.EventoDeportivo;
import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import java.util.Date;
import org.junit.jupiter.api.Test;

class PronosticoFactoryTest {

  @Test
  void creaTiposBasicos() {
    IPronosticoFactory f = new PronosticoFactory();
    Usuario u = new Usuario("U7", "User", "u@test.com");
    EventoDeportivo e = new EventoDeportivo("E7", "Match", new Date());

    Pronostico r = f.crearPronosticoResultado(u, e, "Local");
    Pronostico m = f.crearPronosticoMarcador(u, e, "2-1");

    assertNotNull(r);
    assertEquals("RESULTADO", r.getTipo());
    assertNotNull(m);
    assertEquals("MARCADOR", m.getTipo());
  }
}
