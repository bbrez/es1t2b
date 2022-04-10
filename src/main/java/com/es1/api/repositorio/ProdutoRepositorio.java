package com.es1.api.repositorio;

import com.es1.api.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
}
