package com.sportspredictor.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

  private Usuario usuario;
  private EventoDeportivo evento;

  @BeforeEach
  void setUp() {
    usuario = new Usuario("U001", "Juan", "juan@test.com");
    evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new Date());
  }

  @Test
  void U1_Constructor() {
    assertNotNull(usuario);
    assertEquals("U001", usuario.getId());
    assertEquals("Juan", usuario.getNombreUsuario());
    assertEquals("juan@test.com", usuario.getEmail());
    assertEquals(0, usuario.getPuntos());
  }

  @Test
  void U2_RealizarPronostico() {
    Pronostico pronostico = usuario.realizarPronostico(evento, "Local");

    assertNotNull(pronostico);
    assertEquals("Local", pronostico.getOpcionSeleccionada());
    // Con el refactor no se expone el objeto Usuario/Evento:
    assertEquals(usuario.getId(), pronostico.getUsuarioId());
    assertEquals(evento.getId(), pronostico.getEventoId());
  }

  @Test
  void U3_CanjearPuntosExitoso() {
    usuario.agregarPuntos(100); // en lugar de setPuntos(...)
    boolean resultado = usuario.canjearPuntos(50);

    assertTrue(resultado);
    assertEquals(50, usuario.getPuntos());
  }

  @Test
  void U4_CanjearPuntosInsuficientes() {
    usuario.agregarPuntos(30);
    boolean resultado = usuario.canjearPuntos(50);

    assertFalse(resultado);
    assertEquals(30, usuario.getPuntos()); // los puntos no cambian
  }

  @Test
  void U5_ConsultarHistorial() {
    usuario.realizarPronostico(evento, "Local");
    List<Pronostico> historial = usuario.consultarHistorial();

    assertNotNull(historial);
    assertFalse(historial.isEmpty());
  }
}
