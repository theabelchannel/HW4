package com.sportspredictor.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.sportspredictor.model.EventoDeportivo;
import com.sportspredictor.model.Pronostico;
import com.sportspredictor.model.Usuario;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryPronosticoRepositoryTest {

  private InMemoryPronosticoRepository repo;
  private Usuario u1;
  private Usuario u2;
  private EventoDeportivo e1;

  @BeforeEach
  void setUp() {
    repo = new InMemoryPronosticoRepository();
    u1 = new Usuario("U1", "Juan", "juan@test.com");
    u2 = new Usuario("U2", "Maria", "maria@test.com");
    e1 = new EventoDeportivo("E1", "Partido", new Date());

    repo.guardar(new Pronostico("P1", u1, e1, "Local"));
    repo.guardar(new Pronostico("P2", u1, e1, "Empate"));
    repo.guardar(new Pronostico("P3", u2, e1, "Visita"));
  }

  @Test
  void filtraPorUsuario_correctamente() {
    List<Pronostico> deU1 = repo.obtenerPorUsuario("U1");
    List<Pronostico> deU2 = repo.obtenerPorUsuario("U2");
    List<Pronostico> deNadie = repo.obtenerPorUsuario("NA");

    assertEquals(2, deU1.size());
    assertEquals(1, deU2.size());
    assertTrue(deNadie.isEmpty());
  }
}
