package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Bairro {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idBairro;
    private @Column(nullable = false) String nomeBairro;
}
