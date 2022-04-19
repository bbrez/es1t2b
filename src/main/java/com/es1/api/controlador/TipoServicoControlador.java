package com.es1.api.controlador;

import com.es1.api.modelo.TipoServico;
import com.es1.api.repositorio.TipoServicoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TipoServicoControlador {
    private final TipoServicoRepositorio repositorio;

    TipoServicoControlador(TipoServicoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/tipo_servico")
    List<TipoServico> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/tipo_servico")
    TipoServico novoTipoServico(@RequestBody TipoServico novoTipoServico) {
        return repositorio.save(novoTipoServico);
    }

    //Tipo Serviço individual
    @GetMapping("/tipo_servico/{id}")
    TipoServico um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/tipo_servico/{id}")
    TipoServico substituirTipoServico(@RequestBody TipoServico novoTipoServico, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(tipoServico -> {
                            tipoServico.setNomeTipoServico(novoTipoServico.getNomeTipoServico());
                            tipoServico.setValorMaoDeObra(novoTipoServico.getValorMaoDeObra());
                            return repositorio.save(tipoServico);
                        }
                ).orElseGet(() -> {
                    novoTipoServico.setIdTipoServico(id);
                    return repositorio.save(novoTipoServico);
                });
    }

    @DeleteMapping("/tipo_servico/{id}")
    void deletarTipoServico(@PathVariable Integer id) { repositorio.deleteById(id); }
}
