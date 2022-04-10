package com.es1.api.controlador;

import com.es1.api.modelo.UnidadeFederativa;
import com.es1.api.repositorio.UnidadeFederativaRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnidadeFederativaControlador {
    private final UnidadeFederativaRepositorio repositorio;

    UnidadeFederativaControlador(UnidadeFederativaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/unidade_federativa")
    List<UnidadeFederativa> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/unidade_federativa")
    UnidadeFederativa novaUnidadeFederativa(@RequestBody UnidadeFederativa novaUnidadeFederativa){
        return repositorio.save(novaUnidadeFederativa);
    }


    @GetMapping("/unidade_federativa/{id}")
    UnidadeFederativa um(@PathVariable Integer id){
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/unidade_federativa/{id}")
    UnidadeFederativa substituirUnidadeFederativa(@RequestBody UnidadeFederativa novaUnidadeFederativa, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(unidadeFederativa -> {
                    unidadeFederativa.setNomeUnidadeFederativa(novaUnidadeFederativa.getNomeUnidadeFederativa());
                    return unidadeFederativa;
                }).orElseGet(() -> {
                    novaUnidadeFederativa.setIdUnidadeFederativa(id);
                    return novaUnidadeFederativa;
                });
    }

    @DeleteMapping("/unidade_federativa/{id}")
    void deletarUnidadeFederativa(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
