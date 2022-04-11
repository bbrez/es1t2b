package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Logradouro {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idLogradouro;
    private @Column(nullable = false) String nomeLogradouro;
}
