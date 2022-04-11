package com.es1.api.repositorio;

import com.es1.api.modelo.EstadoOS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EstadoOSRepositorio extends JpaRepository<EstadoOS, Integer> {
    EstadoOS findByNomeEstado(String nomeEstado);
}
