package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Servico {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idServicos;
    private @Column(nullable = false) Float valorMaoDeObra;
    private @Column(nullable = false) String nomeServico;
    private @ManyToOne(cascade = CascadeType.MERGE) OrdemDeServico ordemDeServico;
}
