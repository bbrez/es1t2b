package com.es1.api.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ItemProduto {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idItemProduto;
    private @Column(nullable = false) Integer quantidadeProduto;
    private @ManyToOne(cascade = CascadeType.MERGE) OrdemDeServico ordemDeServico;
    private @ManyToOne(cascade = CascadeType.MERGE) Produto produto;

    @JsonManagedReference
    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }
}
