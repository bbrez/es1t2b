package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UnidadeFederativa {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idUnidadeFederativa;
    private @Column(nullable = false) String nomeUnidadeFederativa;
}
