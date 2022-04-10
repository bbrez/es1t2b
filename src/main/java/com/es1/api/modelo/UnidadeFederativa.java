package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class UnidadeFederativa {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idUnidadeFederativa;
    private String nomeUnidadeFederativa;
}
