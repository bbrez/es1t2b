package com.es1.api.repositorio;

import com.es1.api.modelo.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepositorio extends JpaRepository<TipoServico, Integer> {
}