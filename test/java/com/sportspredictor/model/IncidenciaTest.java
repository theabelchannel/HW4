package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class IncidenciaTest {

  private Incidencia incidencia;
  private Pronostico pronostico;
  private Usuario usuario;
  private EventoDeportivo evento;

  @BeforeEach
  void setUp() {
    usuario = new Usuario("U001", "Juan", "juan@test.com");
    evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new Date());
    pronostico = new Pronostico("P001", usuario, evento, "Local");
    incidencia = new Incidencia("I001", "Error en pronóstico", pronostico, false);
  }

  @Test
  void I1_Constructor_ySnapshot() {
    assertNotNull(incidencia);
    assertEquals("I001", incidencia.getId());
    assertEquals("Error en pronóstico", incidencia.getDescripcion());
    assertEquals("NUEVA", incidencia.getEstado());
    assertFalse(incidencia.isCompleja());

    // Snapshot del pronóstico (sin exponer el objeto)
    assertEquals("P001", incidencia.getPronosticoId());
    assertEquals("U001", incidencia.getUsuarioId());
    assertEquals("E001", incidencia.getEventoId());
    assertEquals("Local", incidencia.getOpcionSeleccionada());
  }

  @Test
  void I2_SetEstado() {
    incidencia.setEstado("RESUELTA");
    assertEquals("RESUELTA", incidencia.getEstado());
  }

  @Test
  void I3_IncidenciaCompleja() {
    Incidencia incidenciaCompleja =
        new Incidencia("I002", "Error complejo", pronostico, true);
    assertTrue(incidenciaCompleja.isCompleja());
  }

  @Test
  void I4_SnapshotConsistente_siPronosticoCambia() {
    // Cambia el pronóstico luego de creada la incidencia
    pronostico.setEstado("ACERTADO");
    // La incidencia conserva su snapshot original
    assertEquals("P001", incidencia.getPronosticoId());
    assertEquals("U001", incidencia.getUsuarioId());
    assertEquals("E001", incidencia.getEventoId());
    assertEquals("Local", incidencia.getOpcionSeleccionada());
  }
}
