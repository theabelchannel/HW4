package com.sportspredictor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

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
        // Verificar creación válida del objeto
        assertNotNull(usuario);
        assertEquals("U001", usuario.getId());
        assertEquals("Juan", usuario.getNombreUsuario());
        assertEquals("juan@test.com", usuario.getEmail());
        assertEquals(0, usuario.getPuntos());
    }
    
    @Test
    void U2_RealizarPronostico() {
        // Validar creación de pronóstico exitosa
        Pronostico pronostico = usuario.realizarPronostico(evento, "Local");
        
        assertNotNull(pronostico);
        assertEquals("Local", pronostico.getOpcionSeleccionada());
        assertEquals(usuario, pronostico.getUsuario());
        assertEquals(evento, pronostico.getEvento());
    }
    
    @Test
    void U3_CanjearPuntosExitoso() {
        // Verificar canje de puntos exitoso
        usuario.setPuntos(100);
        boolean resultado = usuario.canjearPuntos(50);
        
        assertTrue(resultado);
        assertEquals(50, usuario.getPuntos());
    }
    
    @Test
    void U4_CanjearPuntosInsuficientes() {
        // Validar validación de puntos insuficientes
        usuario.setPuntos(30);
        boolean resultado = usuario.canjearPuntos(50);
        
        assertFalse(resultado);
        assertEquals(30, usuario.getPuntos()); // Los puntos no deben cambiar
    }
    
    @Test
    void U5_ConsultarHistorial() {
        // Verificar retorno del historial de pronósticos
        usuario.realizarPronostico(evento, "Local");
        List<Pronostico> historial = usuario.consultarHistorial();
        
        assertNotNull(historial);
        assertFalse(historial.isEmpty());
    }
}
