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

    @GetMapping("/cliente/por_cpf/{cpf}")
    Cliente por_cpf(@PathVariable String cpf){
        return repositorio.findByCpfCliente(cpf);
    }

    @PostMapping("/cliente")
    Cliente novo(@RequestBody Cliente novoCliente) {
        return repositorio.save(novoCliente);
    }


    @GetMapping("/cliente/{id}")
    Cliente um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/cliente/{id}")
    Cliente substituir(@RequestBody Cliente novoCliente, @PathVariable Integer id) {
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
    void deletar(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
