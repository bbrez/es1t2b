package com.es1.api.controlador;

import com.es1.api.modelo.Cliente;
import com.es1.api.repositorio.ClienteRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteControlador {
    private final ClienteRepositorio repositorio;

    ClienteControlador(ClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/cliente")
    List<Cliente> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/cliente")
    Cliente novoCliente(@RequestBody Cliente novoCliente) {
        return repositorio.save(novoCliente);
    }


    @GetMapping("/cliente/{id}")
    Cliente um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/cliente/{id}")
    Cliente substituirCliente(@RequestBody Cliente novoCliente, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(cliente -> {
                    cliente.setNomeCliente(novoCliente.getNomeCliente());
                    cliente.setCpfCliente(novoCliente.getCpfCliente());
                    cliente.setNumCasaCliente(novoCliente.getNumCasaCliente());
                    cliente.setComplementoCasaCliente(novoCliente.getComplementoCasaCliente());
                    cliente.setEndereco(novoCliente.getEndereco());
                    return repositorio.save(cliente);
                }).orElseGet(() -> {
                    novoCliente.setIdCliente(id);
                    return repositorio.save(novoCliente);
                });
    }

    @DeleteMapping("/cliente/{id}")
    void deletarCliente(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
