package com.es1.api.controlador;

import com.es1.api.modelo.ItemProduto;
import com.es1.api.repositorio.ItemProdutoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemProdutoControlador {
    private final ItemProdutoRepositorio repositorio;

    ItemProdutoControlador(ItemProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/item_produto")
    List<ItemProduto> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/item_produto")
    ItemProduto novoItemProduto(@RequestBody ItemProduto novoItemProduto) {
        return repositorio.save(novoItemProduto);
    }


    @GetMapping("/item_produto/{id}")
    ItemProduto um(@PathVariable Integer id) {
        return repositorio.findById(id).orElseThrow();
    }

    @PutMapping("/item_produto/{id}")
    ItemProduto substituirItemProduto(@RequestBody ItemProduto novoItemProduto, @PathVariable Integer id) {
        return repositorio.findById(id)
                .map(itemProduto -> {
                    itemProduto.setQuantidadeProduto(novoItemProduto.getQuantidadeProduto());
                    itemProduto.setProduto(novoItemProduto.getProduto());
                    itemProduto.setOrdemDeServico(novoItemProduto.getOrdemDeServico());
                    return repositorio.save(itemProduto);
                }).orElseGet(() -> {
                    novoItemProduto.setIdItemProduto(id);
                    return repositorio.save(novoItemProduto);
                });
    }

    @DeleteMapping("/item_produto/{id}")
    void deletarItemProduto(@PathVariable Integer id){
        repositorio.deleteById(id);
    }
}
