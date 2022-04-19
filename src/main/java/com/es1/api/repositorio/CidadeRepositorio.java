package com.es1.api.repositorio;

import com.es1.api.modelo.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepositorio extends JpaRepository<Cidade, Integer> {
    @Query("select c from Cidade c where c.nomeCidade = ?1")
    List<Cidade> findByNomeCidade(String nomeCidade);

}
