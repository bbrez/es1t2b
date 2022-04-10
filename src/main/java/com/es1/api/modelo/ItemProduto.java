package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ItemProduto {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idItemProduto;
    private Integer quantidadeProduto;
    private @ManyToOne(cascade = CascadeType.ALL) OrdemDeServico ordemDeServico;
    private @ManyToOne(cascade = CascadeType.ALL) Produto produto;
}
