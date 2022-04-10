package com.es1.api.controlador;

import com.es1.api.modelo.DDI;
import com.es1.api.repositorio.DDIRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DDIController {
    private final DDIRepositorio repositorio;

    DDIController(DDIRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/ddi")
    List<DDI> todos(){
        return repositorio.findAll();
    }

    @PostMapping("/ddi")
    DDI novoDDI(@RequestBody DDI novoDDI){
        return repositorio.save(novoDDI);
    }


    @GetMapping("/ddi/{id}")
    DDI um(@PathVariable Integer id){
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/ddi/{id}")
    DDI substituirDDI(@RequestBody DDI novoDDI, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(ddi -> {
                    ddi.setNumeroDDI(novoDDI.getNumeroDDI());
                    return repositorio.save(ddi);
                }).orElseGet(() -> {
                    novoDDI.setIdDDI(id);
                    return repositorio.save(novoDDI);
                });
    }

    @DeleteMapping("/ddi/{id}")
    void deletarDDI(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
