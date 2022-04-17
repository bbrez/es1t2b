package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cidade {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idCidade;
    private @Column(nullable = false) String nomeCidade;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private UnidadeFederativa unidadeFederativa;
}
