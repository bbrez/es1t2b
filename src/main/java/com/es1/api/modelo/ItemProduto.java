package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ItemProduto {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idItemProduto;
    private @Column(nullable = false) Integer quantidadeProduto;
    private @ManyToOne(cascade = CascadeType.MERGE) OrdemDeServico ordemDeServico;
    private @ManyToOne(cascade = CascadeType.MERGE) Produto produto;
}
