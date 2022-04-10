package com.es1.api.repositorio;

import com.es1.api.modelo.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {
}
