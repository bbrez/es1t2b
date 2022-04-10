package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Cidade {
    private @Id @GeneratedValue Integer idCidade;
    private String nomeCidade;

    @ManyToOne
    private UnidadeFederativa unidadeFederativa;
}
