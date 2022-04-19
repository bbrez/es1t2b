package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Telefone {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idTelefone;
    private @Column(nullable = false) String numeroTelefone;
    private @ManyToOne(cascade = CascadeType.MERGE) Cliente cliente;
}
