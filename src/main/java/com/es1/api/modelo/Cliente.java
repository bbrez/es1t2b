package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Cliente {
    private @Id @GeneratedValue Integer idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private Integer numCasaCliente;
    private String complementoCasaCliente;

    @ManyToOne
    Endereco endereco;
}
