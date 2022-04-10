package com.es1.api.controlador;

import com.es1.api.modelo.Servico;
import com.es1.api.repositorio.ServicoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServicoControlador {
    private final ServicoRepositorio repositorio;

    ServicoControlador(ServicoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/servico")
    List<Servico> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/servico")
    Servico novoServico(@RequestBody Servico novoServico) {
        return repositorio.save(novoServico);
    }


    @GetMapping("/servico/{id}")
    Servico um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/servico/{id}")
    Servico substituirServico(@RequestBody Servico novoServico, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(servico -> {
                    servico.setValorMaoDeObra(novoServico.getValorMaoDeObra());
                    servico.setTipoServico(novoServico.getTipoServico());
                    servico.setOrdemDeServico(novoServico.getOrdemDeServico());
                    return repositorio.save(servico);
                }).orElseGet(() -> {
                    novoServico.setIdServicos(id);
                    return repositorio.save(novoServico);
                });
    }

    @DeleteMapping("/servico/{id}")
    void deletarServico(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }
}
