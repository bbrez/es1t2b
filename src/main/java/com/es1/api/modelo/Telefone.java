package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Telefone {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idTelefone;
    private String numeroTelefone;
    private @ManyToOne(cascade = CascadeType.MERGE) DDI ddi;
    private @ManyToOne(cascade = CascadeType.MERGE) DDD ddd;
    private @ManyToOne(cascade = CascadeType.MERGE) Cliente cliente;
}
