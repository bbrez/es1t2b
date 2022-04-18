package com.es1.api.controlador;

import com.es1.api.modelo.OrdemDeServico;
import com.es1.api.repositorio.EstadoOSRepositorio;
import com.es1.api.repositorio.OrdemDeServicoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdemDeServicoControlador {
    private final OrdemDeServicoRepositorio repositorio;
    private final EstadoOSRepositorio repoEstado;

    OrdemDeServicoControlador(OrdemDeServicoRepositorio repositorio, EstadoOSRepositorio repoEstado){
        this.repositorio = repositorio;
        this.repoEstado = repoEstado;
    }

    @GetMapping("/ordem_servico")
    List<OrdemDeServico> todos() {
        return repositorio.findAll();
    }

    @GetMapping("/ordem_servico/por_id_cliente/{idCliente}")
    List<OrdemDeServico> porIDCliente(@PathVariable Integer idCliente){
        return repositorio.findByCliente_IdCliente(idCliente);
    }

    @GetMapping("/ordem_servico/por_cpf_cliente/{cpf}")
    List<OrdemDeServico> porCPFCliente(@PathVariable String cpf){
        return repositorio.findByCliente_CpfCliente(cpf);
    }

    @PostMapping("/ordem_servico")
    OrdemDeServico novaOrdemDeServico(@RequestBody OrdemDeServico novaOrdemDeServico){
        return repositorio.save(novaOrdemDeServico);
    }


    @GetMapping("/ordem_servico/{id}")
    OrdemDeServico um(@PathVariable Integer id){
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/ordem_servico/{id}")
    OrdemDeServico substituirOrdemDeServico(@RequestBody OrdemDeServico novaOrdemDeServico, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(ordemDeServico -> {
                    ordemDeServico.setDataOrdemServico(novaOrdemDeServico.getDataOrdemServico());
                    ordemDeServico.setCliente(novaOrdemDeServico.getCliente());
                    ordemDeServico.setVeiculo(novaOrdemDeServico.getVeiculo());
                    return repositorio.save(ordemDeServico);
                }).orElseGet(() -> {
                    novaOrdemDeServico.setNroOrdemDeServico(id);
                    return repositorio.save(novaOrdemDeServico);
                });
    }

    @DeleteMapping("/ordem_servico/{id}")
    void deletarOrdemDeServico(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }


    @PostMapping("/ordem_servico/{id}/completar")
    OrdemDeServico completar(@PathVariable Integer id){
        return repositorio.findById(id)
                .map(ordemDeServico -> {
                    ordemDeServico.setEstado(repoEstado.findByNomeEstado("Completo"));
                    return repositorio.save(ordemDeServico);
                }).orElseThrow();
    }

    @PostMapping("/ordem_servico/{id}/cancelar")
    OrdemDeServico cancelar(@PathVariable Integer id){
        return repositorio.findById(id)
                .map(ordemDeServico -> {
                    ordemDeServico.setEstado(repoEstado.findByNomeEstado("Cancelado"));
                    return repositorio.save(ordemDeServico);
                }).orElseThrow();
    }

    @PostMapping("/ordem_servico/{id}/aprovar")
    OrdemDeServico aprovar(@PathVariable Integer id){
        return repositorio.findById(id)
                .map(ordemDeServico -> {
                    ordemDeServico.setEstado(repoEstado.findByNomeEstado("Ativo"));
                    return repositorio.save(ordemDeServico);
                }).orElseThrow();
    }
}
