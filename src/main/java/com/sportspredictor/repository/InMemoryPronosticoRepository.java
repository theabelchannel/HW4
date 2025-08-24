package com.sportspredictor.repository;

import com.sportspredictor.model.Pronostico;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryPronosticoRepository implements IPronosticoRepository {

  private final Map<String, Pronostico> pronosticos = new HashMap<>();

  @Override
  public void guardar(Pronostico pronostico) {
    pronosticos.put(pronostico.getId(), pronostico);
    System.out.println(
        "Repositorio: Pronóstico " + pronostico.getId() + " guardado en memoria.");
  }

  @Override
  public List<Pronostico> obtenerPorUsuario(String usuarioId) {
    return pronosticos.values().stream()
        .filter(p -> usuarioId != null && usuarioId.equals(p.getUsuarioId()))
        .collect(Collectors.toList());
  }
}
