package com.es1.api.repositorio;

import com.es1.api.modelo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepositorio extends JpaRepository<Veiculo, Integer> {
}
