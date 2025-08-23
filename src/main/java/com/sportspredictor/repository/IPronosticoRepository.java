package com.sportspredictor.repository;

import com.sportspredictor.model.Pronostico;
import java.util.List;

public interface IPronosticoRepository {
    void guardar(Pronostico pronostico);
    List<Pronostico> obtenerPorUsuario(String usuarioId);
} 