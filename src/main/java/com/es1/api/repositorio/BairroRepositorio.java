package com.es1.api.repositorio;

import com.es1.api.modelo.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BairroRepositorio extends JpaRepository<Bairro, Integer> {
    List<Bairro> findByNomeBairro(String nomeBairro);

}
