package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Veiculo {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idVeiculo;
    private String nomeVeiculo;
    private String placa;
    private String modelo;
    private Integer kmVeiculo;
    private @ManyToOne(cascade = CascadeType.ALL) Marca marca;
}
