package com.es1.api.controlador;

import com.es1.api.modelo.Produto;
import com.es1.api.repositorio.ProdutoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoControlador {
    private final ProdutoRepositorio repositorio;

    ProdutoControlador(ProdutoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/produto")
    List<Produto> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/produto")
    Produto novoProduto(@RequestBody Produto novoProduto){
        return repositorio.save(novoProduto);
    }


    @GetMapping("/produto/{id}")
    Produto um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/produto/{id}")
    Produto substituirProduto(@RequestBody Produto novoProduto, @PathVariable Integer id){
        return repositorio.findById(id)
                .map(produto -> {
                    produto.setNomeProduto(novoProduto.getNomeProduto());
                    produto.setValorItem(novoProduto.getValorItem());
                    return repositorio.save(produto);
                }).orElseGet(() -> {
                    novoProduto.setCodProduto(id);
                    return repositorio.save(novoProduto);
                });
    }

    @DeleteMapping("/produto/{id}")
    void deletarProduto(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }
}
