package com.es1.api.controlador;

import com.es1.api.modelo.Bairro;
import com.es1.api.repositorio.BairroRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BairroControlador {
    private final BairroRepositorio repositorio;

    BairroControlador(BairroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/bairro")
    List<Bairro> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/bairro")
    Bairro novoBairro(@RequestBody Bairro novoBairro) {
        return repositorio.save(novoBairro);
    }

    @GetMapping("/bairro/{id}")
    Bairro umBairro(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/bairro/{id}")
    Bairro substituirBairro(@RequestBody Bairro novoBairro, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(bairro -> {
                    bairro.setNomeBairro(novoBairro.getNomeBairro());
                    return repositorio.save(bairro);
                }).orElseGet(() -> {
                    novoBairro.setIdBairro(id);
                    return repositorio.save(novoBairro);
                });
    }

    @DeleteMapping("/bairro/{id}")
    void deletarBairro(@PathVariable Integer id) { repositorio.deleteById(id); }
}
