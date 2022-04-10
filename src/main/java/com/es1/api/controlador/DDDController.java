package com.es1.api.controlador;

import com.es1.api.modelo.DDD;
import com.es1.api.repositorio.DDDRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DDDController {
    private final DDDRepositorio repositorio;

    DDDController(DDDRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/ddd")
    List<DDD> todos(){
        return repositorio.findAll();
    }

    @PostMapping("/ddd")
    DDD novoDDD(@RequestBody DDD novoDDD){
        return repositorio.save(novoDDD);
    }


    @GetMapping("/ddd/{id}")
    DDD um(@PathVariable Integer id){
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/ddd/{id}")
    DDD substituirDDD(@RequestBody DDD novoDDD, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(ddd -> {
                    ddd.setNumeroDDD(novoDDD.getNumeroDDD());
                    return repositorio.save(ddd);
                }).orElseGet(() -> {
                    novoDDD.setIdDDD(id);
                    return repositorio.save(novoDDD);
                });
    }

    @DeleteMapping("/ddd/{id}")
    void deletarDDD(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
