package com.es1.api.repositorio;

import com.es1.api.modelo.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {
    List<Cidade> findByNomeCidade(String nomeCidade);
}
