package com.es1.api.repositorio;

import com.es1.api.modelo.EstadoOS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EstadoOSRepositorio extends JpaRepository<EstadoOS, Integer> {
    @Query("select e from EstadoOS e where e.nomeEstado = ?1")
    EstadoOS findByNomeEstado(String nomeEstado);

}
