package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Clase concreta para probar la clase abstracta Cuenta
class CuentaConcreta extends Cuenta {
    public CuentaConcreta(String id, String nombreUsuario, String email) {
        super(id, nombreUsuario, email);
    }
}

public class CuentaTest {
    
    private CuentaConcreta cuenta;
    
    @BeforeEach
    void setUp() {
        cuenta = new CuentaConcreta("C001", "Admin", "admin@test.com");
    }
    
    @Test
    void C1_Constructor() {
        // Verificar creación válida del objeto
        assertNotNull(cuenta);
        assertEquals("C001", cuenta.getId());
        assertEquals("Admin", cuenta.getNombreUsuario());
        assertEquals("admin@test.com", cuenta.getEmail());
    }
    
    @Test
    void C2_Login() {
        // Validar autenticación correcta
        boolean resultado = cuenta.login("admin@test.com", "123");
        assertTrue(resultado);
    }
    
    @Test
    void C3_Logout() {
        // Verificar cierre de sesión
        cuenta.login("admin@test.com", "123");
        assertDoesNotThrow(() -> cuenta.logout());
    }
    
    @Test
    void C4_SetTelefonoGetTelefono() {
        // Validar setter y getter de teléfono
        cuenta.setTelefono("987654321");
        assertEquals("987654321", cuenta.getTelefono());
    }
    
    @Test
    void C5_Herencia() {
        // Verificar herencia correcta de Usuario
        Usuario usuario = new Usuario("U001", "Juan", "juan@test.com");
        assertTrue(usuario instanceof Cuenta);
    }
}
