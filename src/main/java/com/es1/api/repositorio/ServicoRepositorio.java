package com.es1.api.repositorio;

import com.es1.api.modelo.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepositorio extends JpaRepository<Servico, Integer> {
}
