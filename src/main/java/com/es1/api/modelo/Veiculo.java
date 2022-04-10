package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Veiculo {
    private @Id @GeneratedValue Integer idVeiculo;
    private String nomeVeiculo;
    private String placa;
    private String modelo;
    private Integer kmVeiculo;
    private @ManyToOne Marca marca;
}
