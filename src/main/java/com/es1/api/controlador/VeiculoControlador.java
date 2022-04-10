package com.es1.api.controlador;

import com.es1.api.modelo.Veiculo;
import com.es1.api.repositorio.VeiculoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeiculoControlador {
    private final VeiculoRepositorio repositorio;

    VeiculoControlador(VeiculoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/veiculo")
    List<Veiculo> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/veiculo")
    Veiculo novoVeiculo(@RequestBody Veiculo novoVeiculo) {
        return repositorio.save(novoVeiculo);
    }

    //Veiculo Individual
    @GetMapping("/veiculo/{id}")
    Veiculo um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/veiculo/{id}")
    Veiculo substituirVeiculo(@RequestBody Veiculo novoVeiculo, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(veiculo -> {
                    veiculo.setNomeVeiculo(novoVeiculo.getNomeVeiculo());
                    veiculo.setKmVeiculo(novoVeiculo.getKmVeiculo());
                    veiculo.setModelo(novoVeiculo.getModelo());
                    veiculo.setPlaca(novoVeiculo.getPlaca());
                    veiculo.setMarca(novoVeiculo.getMarca());
                    return repositorio.save(veiculo);
                }).orElseGet(() -> {
                    novoVeiculo.setIdVeiculo(id);
                    return repositorio.save(novoVeiculo);
                });
    }

    @DeleteMapping("/veiculo/{id}")
    void deletarVeiculo(@PathVariable Integer id) { repositorio.deleteById(id); }
}
