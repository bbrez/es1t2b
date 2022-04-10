package com.es1.api.controlador;

import com.es1.api.modelo.Logradouro;
import com.es1.api.repositorio.LogradouroRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogradouroControlador {
    private final LogradouroRepositorio repositorio;

    LogradouroControlador(LogradouroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/logradouro")
    List<Logradouro> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/logradouro")
    Logradouro novoLogradouro(@RequestBody Logradouro novoLogradouro) {
        return repositorio.save(novoLogradouro);
    }


    @GetMapping("/logradouro/{id}")
    Logradouro um(@PathVariable Integer id){
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/logradouro/{id}")
    Logradouro substituirLogradouro(@RequestBody Logradouro novoLogradouro, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(logradouro -> {
                    logradouro.setNomeLogradouro(novoLogradouro.getNomeLogradouro());
                    logradouro.setTipoLogradouro(novoLogradouro.getTipoLogradouro());
                    return repositorio.save(logradouro);
                }).orElseGet(() -> {
                    novoLogradouro.setIdLogradouro(id);
                    return repositorio.save(novoLogradouro);
                });
    }

    @DeleteMapping("/logradouro/{id}")
    void deletarLogradouro(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
