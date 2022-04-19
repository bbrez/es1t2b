package com.es1.api.repositorio;

import com.es1.api.modelo.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdemDeServicoRepositorio extends JpaRepository<OrdemDeServico, Integer> {
    @Query("select o from OrdemDeServico o where o.cliente.cpfCliente = ?1 and o.estado.nomeEstado = ?2")
    List<OrdemDeServico> findByCliente_CpfClienteAndEstado_NomeEstado(String cpfCliente, String nomeEstado);

    @Query("select o from OrdemDeServico o where o.cliente.idCliente = ?1")
    List<OrdemDeServico> findByCliente_IdCliente(Integer idCliente);

    @Query("select o from OrdemDeServico o where o.cliente.cpfCliente = ?1")
    List<OrdemDeServico> findByCliente_CpfCliente(String cpfCliente);

    @Query("select o from OrdemDeServico o where o.estado.nomeEstado = ?1")
    List<OrdemDeServico> findByEstado_NomeEstado(String nomeEstado);

}
