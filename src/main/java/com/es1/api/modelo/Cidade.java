package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cidade {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idCidade;
    private String nomeCidade;

    @ManyToOne(cascade = CascadeType.ALL)
    private UnidadeFederativa unidadeFederativa;
}
