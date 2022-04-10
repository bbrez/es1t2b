package com.es1.api.repositorio;

import com.es1.api.modelo.ItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemProdutoRepositorio extends JpaRepository<ItemProduto, Integer> {
}
