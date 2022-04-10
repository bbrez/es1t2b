package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Servico {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idServicos;
    private Float valorMaoDeObra;
    private @ManyToOne(cascade = CascadeType.ALL) TipoServico tipoServico;
    private @ManyToOne(cascade = CascadeType.ALL) OrdemDeServico ordemDeServico;
}
