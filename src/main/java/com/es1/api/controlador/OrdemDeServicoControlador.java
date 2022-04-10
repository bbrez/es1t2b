package com.es1.api.controlador;

import com.es1.api.modelo.OrdemDeServico;
import com.es1.api.repositorio.OrdemDeServicoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdemDeServicoControlador {
    private final OrdemDeServicoRepositorio repositorio;

    OrdemDeServicoControlador(OrdemDeServicoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/ordem_servico")
    List<OrdemDeServico> todos() {
        return repositorio.findAll();
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
}
