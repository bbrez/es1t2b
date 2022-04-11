package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Produto {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer codProduto;
    private @Column(nullable = false) String nomeProduto;
    private @Column(nullable = false) Float valorItem;
}
