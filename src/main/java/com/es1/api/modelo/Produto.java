package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Produto {
    private @Id @GeneratedValue Integer codProduto;
    private String nomeProduto;
    private Float valorItem;
}
