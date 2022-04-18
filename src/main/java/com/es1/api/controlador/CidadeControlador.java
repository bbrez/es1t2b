package com.es1.api.controlador;

import com.es1.api.modelo.Cidade;
import com.es1.api.repositorio.CidadeRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CidadeControlador {
    private final CidadeRepositorio repositorio;

    CidadeControlador(CidadeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/cidade")
    List<Cidade> todos() {
        return repositorio.findAll();
    }

    @GetMapping("/cidade/por_nome/{nome}")
    List<Cidade> por_nome(@PathVariable String nome){
        return repositorio.findByNomeCidade(nome);
    }

    @PostMapping("/cidade")
    Cidade novo(@RequestBody Cidade novaCidade) {
        return repositorio.save(novaCidade);
    }


    @GetMapping("/cidade/{id}")
    Cidade um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/cidade/{id}")
    Cidade substituir(@RequestBody Cidade novaCidade, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(cidade -> {
                    cidade.setNomeCidade(novaCidade.getNomeCidade());
                    cidade.setUnidadeFederativa(novaCidade.getUnidadeFederativa());
                    return repositorio.save(cidade);
                }).orElseGet(() -> {
                    novaCidade.setIdCidade(id);
                    return repositorio.save(novaCidade);
                });
    }

    @DeleteMapping("/cidade/{id}")
    void deletar(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }
}
