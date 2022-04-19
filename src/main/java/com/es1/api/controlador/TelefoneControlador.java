package com.es1.api.controlador;

import com.es1.api.modelo.Telefone;
import com.es1.api.repositorio.TelefoneRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelefoneControlador {
    private final TelefoneRepositorio repositorio;

    TelefoneControlador(TelefoneRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/telefone")
    List<Telefone> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/telefone")
    Telefone novoTelefone(@RequestBody Telefone novoTelefone) {
        return repositorio.save(novoTelefone);
    }


    @GetMapping("/telefone/{id}")
    Telefone um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/telefone/{id}")
    Telefone substituirTelefone(@RequestBody Telefone novoTelefone, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(telefone -> {
                    telefone.setNumeroTelefone(novoTelefone.getNumeroTelefone());
                    telefone.setCliente(novoTelefone.getCliente());
                    return telefone;
                }).orElseGet(() -> {
                    novoTelefone.setIdTelefone(id);
                    return repositorio.save(novoTelefone);
                });
    }

    @DeleteMapping("/telefone/{id}")
    void deletarTelefone(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
