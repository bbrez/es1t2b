package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idEndereco;
    private @Column(unique = true, nullable = false) String CEP;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Cidade cidade;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Bairro bairro;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Logradouro logradouro;
}
