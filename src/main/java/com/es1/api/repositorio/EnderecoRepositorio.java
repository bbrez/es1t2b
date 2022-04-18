package com.es1.api.repositorio;

import com.es1.api.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {
    Endereco findByCEP(String CEP);
}

