package com.es1.api.controlador;

import com.es1.api.modelo.Endereco;
import com.es1.api.repositorio.EnderecoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoControlador {
    private final EnderecoRepositorio repositorio;

    EnderecoControlador(EnderecoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/endereco")
    List<Endereco> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/endereco")
    Endereco novo(@RequestBody Endereco novoEndereco) {
        System.out.println(novoEndereco.toString());
        return repositorio.save(novoEndereco);
    }


    @GetMapping("/endereco/{id}")
    Endereco um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/endereco/{id}")
    Endereco substituir(@RequestBody Endereco novoEndereco, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(endereco -> {
                    endereco.setBairro(novoEndereco.getBairro());
                    endereco.setCEP(novoEndereco.getCEP());
                    endereco.setCidade(novoEndereco.getCidade());
                    endereco.setLogradouro(novoEndereco.getLogradouro());
                    return repositorio.save(endereco);
                }).orElseGet(() -> {
                    novoEndereco.setIdEndereco(id);
                    return repositorio.save(novoEndereco);
                });
    }

    @DeleteMapping("/endereco/{id}")
    void deletar(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
