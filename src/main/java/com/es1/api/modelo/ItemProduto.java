package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ItemProduto {
    private @Id @GeneratedValue Integer idItemProduto;
    private Integer quantidadeProduto;
    private @ManyToOne OrdemDeServico ordemDeServico;
    private @ManyToOne Produto produto;
}