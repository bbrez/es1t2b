package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Veiculo {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idVeiculo;
    private @Column(nullable = false) String nomeVeiculo;
    private @Column(nullable = false) String placa;
    private @Column(nullable = false) String modelo;
    private @Column(nullable = false) Integer kmVeiculo;
    private @ManyToOne(cascade = CascadeType.MERGE) Marca marca;
}
