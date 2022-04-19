package com.es1.api.repositorio;

import com.es1.api.modelo.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BairroRepositorio extends JpaRepository<Bairro, Integer> {
    @Query("select b from Bairro b where b.nomeBairro = ?1")
    List<Bairro> findByNomeBairro(String nomeBairro);


}
