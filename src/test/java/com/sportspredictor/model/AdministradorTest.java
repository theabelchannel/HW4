package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {
    
    private Administrador administrador;
    
    @BeforeEach
    void setUp() {
        administrador = new Administrador("A001", "Admin", "admin@test.com");
    }
    
    @Test
    void A1_Constructor() {
        // Verificar creación válida del objeto
        assertNotNull(administrador);
        assertEquals("A001", administrador.getId());
        assertEquals("Admin", administrador.getNombreUsuario());
        assertEquals("admin@test.com", administrador.getEmail());
    }
    
    @Test
    void A2_GestionarOpciones() {
        // Validar gestión de opciones del sistema
        EventoDeportivo evento = new EventoDeportivo("E001", "Barcelona vs Madrid", new java.util.Date());
        assertDoesNotThrow(() -> administrador.gestionarOpciones(evento, "Victoria, Empate, Derrota"));
    }
    
    @Test
    void A3_GestionarReglas() {
        // Verificar gestión de reglas del sistema
        assertDoesNotThrow(() -> administrador.gestionarReglas("Nuevas reglas de puntuación"));
    }
    
    @Test
    void A4_Herencia() {
        // Validar herencia correcta de Cuenta
        assertTrue(administrador instanceof Cuenta);
    }
    
    @Test
    void A5_Login() {
        // Verificar autenticación del administrador
        boolean resultado = administrador.login("admin@test.com", "123");
        assertTrue(resultado);
    }
}
