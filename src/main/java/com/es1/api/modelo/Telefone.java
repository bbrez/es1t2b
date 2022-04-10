package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Telefone {
    private @Id @GeneratedValue Integer idTelefone;
    private String numeroTelefone;
    private @ManyToOne DDI ddi;
    private @ManyToOne DDD ddd;
    private @ManyToOne Cliente cliente;
}
