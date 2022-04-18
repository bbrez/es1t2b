package com.es1.api.repositorio;

import com.es1.api.modelo.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdemDeServicoRepositorio extends JpaRepository<OrdemDeServico, Integer> {
    List<OrdemDeServico> findByCliente_IdCliente(Integer idCliente);

    List<OrdemDeServico> findByCliente_CpfCliente(String cpfCliente);

    List<OrdemDeServico> findByEstado_NomeEstado(String nomeEstado);



}
