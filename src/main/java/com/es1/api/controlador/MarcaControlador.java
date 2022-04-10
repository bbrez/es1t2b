package com.es1.api.controlador;

import com.es1.api.modelo.Marca;
import com.es1.api.repositorio.MarcaRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarcaControlador {
    private final MarcaRepositorio repositorio;

    MarcaControlador(MarcaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/marca")
    List<Marca> todos(){
        return repositorio.findAll();
    }

    @PostMapping("/marca")
    Marca novaMarca(@RequestBody Marca novaMarca){
        return repositorio.save(novaMarca);
    }

    //Marca Individual
    @GetMapping("/marca/{id}")
    Marca um(@PathVariable Integer id){
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/marca/{id}")
    Marca substituirMarca(@RequestBody Marca novaMarca, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(marca -> {
                    marca.setNomeMarca(novaMarca.getNomeMarca());
                    return repositorio.save(marca);
                }).orElseGet(() -> {
                    novaMarca.setIdMarca(id);
                    return repositorio.save(novaMarca);
                });
    }

    @DeleteMapping("/marca/{id}")
    void deletarMarca(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
