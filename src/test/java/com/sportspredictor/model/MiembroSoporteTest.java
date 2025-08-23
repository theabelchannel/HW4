package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiembroSoporteTest {
    
    private MiembroSoporte miembroSoporte;
    private Incidencia incidencia;
    
    @BeforeEach
    void setUp() {
        miembroSoporte = new MiembroSoporte("MS001", "Soporte", "soporte@test.com");
        Usuario usuario = new Usuario("U001", "Juan", "juan@test.com");
        EventoDeportivo evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new java.util.Date());
        Pronostico pronostico = new Pronostico("P001", usuario, evento, "Local");
        incidencia = new Incidencia("I001", "Error en pronóstico", pronostico, false);
    }
    
    @Test
    void MS1_Constructor() {
        // Verificar creación válida del objeto
        assertNotNull(miembroSoporte);
        assertEquals("MS001", miembroSoporte.getId());
        assertEquals("Soporte", miembroSoporte.getNombreUsuario());
        assertEquals("soporte@test.com", miembroSoporte.getEmail());
    }
    
    @Test
    void MS2_GestionarIncidenciaSimple() {
        // Validar gestión de incidencia simple
        assertDoesNotThrow(() -> miembroSoporte.gestionarIncidencia(incidencia));
    }
    
    @Test
    void MS3_GestionarIncidenciaCompleja() {
        // Verificar escalamiento de incidencia compleja
        Incidencia incidenciaCompleja = new Incidencia("I002", "Error complejo", incidencia.getPronosticoAfectado(), true);
        assertDoesNotThrow(() -> miembroSoporte.gestionarIncidencia(incidenciaCompleja));
    }
    
    @Test
    void MS4_Herencia() {
        // Validar herencia correcta de Cuenta
        assertTrue(miembroSoporte instanceof Cuenta);
    }
    
    @Test
    void MS5_Login() {
        // Verificar autenticación del miembro de soporte
        boolean resultado = miembroSoporte.login("soporte@test.com", "123");
        assertTrue(resultado);
    }
}
