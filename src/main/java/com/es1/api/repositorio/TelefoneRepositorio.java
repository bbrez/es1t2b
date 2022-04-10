package com.es1.api.repositorio;

import com.es1.api.modelo.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepositorio extends JpaRepository<Telefone, Integer> {
}
