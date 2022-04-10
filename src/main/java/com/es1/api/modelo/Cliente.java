package com.es1.api.modelo;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Cliente {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private Integer numCasaCliente;
    private String complementoCasaCliente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
