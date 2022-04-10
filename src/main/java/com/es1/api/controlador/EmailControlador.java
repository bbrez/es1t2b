package com.es1.api.controlador;

import com.es1.api.modelo.Email;
import com.es1.api.repositorio.EmailRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailControlador {
    private final EmailRepositorio repositorio;

    EmailControlador(EmailRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/email")
    List<Email> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/email")
    Email novoEmail(@RequestBody Email novoEmail) {
        return repositorio.save(novoEmail);
    }


    @GetMapping("/email/{id}")
    Email um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/email/{id}")
    Email substituirEmail(@RequestBody Email novoEmail, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(email -> {
                    email.setEmail(novoEmail.getEmail());
                    email.setCliente(novoEmail.getCliente());
                    return repositorio.save(email);
                }).orElseGet(() -> {
                    novoEmail.setIdEmail(id);
                    return repositorio.save(novoEmail);
                });
    }

    @DeleteMapping("/email/{id}")
    void deletarEmail(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }
}
