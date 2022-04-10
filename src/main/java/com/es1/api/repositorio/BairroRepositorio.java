package com.es1.api.repositorio;

import com.es1.api.modelo.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepositorio extends JpaRepository<Bairro, Integer> {
}
