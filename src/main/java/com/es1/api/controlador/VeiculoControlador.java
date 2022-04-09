package com.es1.api.controlador;

import com.es1.api.modelo.Veiculo;
import com.es1.api.repositorio.VeiculoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VeiculoControlador {
    private final VeiculoRepositorio repositorio;

    VeiculoControlador(VeiculoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/veiculo")
    List<Veiculo> todos(){ return repositorio.findAll(); }
}
