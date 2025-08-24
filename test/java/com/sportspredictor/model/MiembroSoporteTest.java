package com.sportspredictor.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiembroSoporteTest {

  private MiembroSoporte miembroSoporte;
  private Incidencia incidencia;
  private Pronostico pronostico; // <-- ahora es campo para reutilizar

  @BeforeEach
  void setUp() {
    miembroSoporte = new MiembroSoporte("MS001", "Soporte", "soporte@test.com");
    Usuario usuario = new Usuario("U001", "Juan", "juan@test.com");
    EventoDeportivo evento =
        new EventoDeportivo("E001", "Barcelona vs Madrid", new java.util.Date());
    pronostico = new Pronostico("P001", usuario, evento, "Local");
    incidencia = new Incidencia("I001", "Error en pronóstico", pronostico, false);
  }

  @Test
  void MS1_Constructor() {
    assertNotNull(miembroSoporte);
    assertEquals("MS001", miembroSoporte.getId());
    assertEquals("Soporte", miembroSoporte.getNombreUsuario());
    assertEquals("soporte@test.com", miembroSoporte.getEmail());
  }

  @Test
  void MS2_GestionarIncidenciaSimple() {
    assertDoesNotThrow(() -> miembroSoporte.gestionarIncidencia(incidencia));
  }

  @Test
  void MS3_GestionarIncidenciaCompleja() {
    // Creamos una incidencia compleja usando el mismo pronóstico (sin getPronosticoAfectado())
    Incidencia incidenciaCompleja =
        new Incidencia("I002", "Error complejo", pronostico, true);
    assertDoesNotThrow(() -> miembroSoporte.gestionarIncidencia(incidenciaCompleja));
  }

  @Test
  void MS4_Herencia() {
    assertTrue(miembroSoporte instanceof Cuenta);
  }

  @Test
  void MS5_Login() {
    boolean resultado = miembroSoporte.login("soporte@test.com", "123");
    assertTrue(resultado);
  }
}
