package com.es1.api.controlador;

import com.es1.api.modelo.TipoLogradouro;
import com.es1.api.repositorio.TipoLogradouroRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TipoLogradouroControlador {
    private final TipoLogradouroRepositorio repositorio;

    TipoLogradouroControlador(TipoLogradouroRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/tipo_logradouro")
    List<TipoLogradouro> todos(){
        return repositorio.findAll();
    }

    @PostMapping("/tipo_logradouro")
    TipoLogradouro novoTipoLogradouro(@RequestBody TipoLogradouro novoTipoLogradouro) {
        return repositorio.save(novoTipoLogradouro);
    }


    @GetMapping("/tipo_logradouro/{id}")
    TipoLogradouro um(@PathVariable Integer id){
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/tipo_logradouro/{id}")
    TipoLogradouro substituirTipoLogradouro(@RequestBody TipoLogradouro novoTipoLogradouro, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(tipoLogradouro -> {
                    tipoLogradouro.setNomeTipoLogradouro(novoTipoLogradouro.getNomeTipoLogradouro());
                    return repositorio.save(tipoLogradouro);
                }).orElseGet(() -> {
                    novoTipoLogradouro.setIdTipoLogradouro(id);
                    return repositorio.save(novoTipoLogradouro);
                });
    }

    @DeleteMapping("/tipo_logradouro/{id}")
    void deletarTipoLogradouro(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
