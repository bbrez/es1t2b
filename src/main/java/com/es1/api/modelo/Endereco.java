package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idEndereco;
    private String CEP;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bairro bairro;

    @ManyToOne(cascade = CascadeType.ALL)
    private Logradouro logradouro;
}
