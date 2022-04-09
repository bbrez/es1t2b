package com.es1.api.repositorio;

import com.es1.api.modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepositorio extends JpaRepository<Marca, Integer> {
}
