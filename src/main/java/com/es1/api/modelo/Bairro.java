package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Bairro {
    private @Id @GeneratedValue Integer idBairro;
    private String nomeBairro;
}
