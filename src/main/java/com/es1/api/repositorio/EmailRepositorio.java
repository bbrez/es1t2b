package com.es1.api.repositorio;

import com.es1.api.modelo.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepositorio extends JpaRepository<Email, Integer> {
}
