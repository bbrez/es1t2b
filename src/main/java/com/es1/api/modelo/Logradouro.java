package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Logradouro {
    private @Id @GeneratedValue Integer idLogradouro;
    private String nomeLogradouro;

    @ManyToOne
    TipoLogradouro tipoLogradouro;
}
