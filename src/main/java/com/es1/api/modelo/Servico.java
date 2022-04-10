package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Servico {
    private @Id @GeneratedValue Integer idServicos;
    private Float valorMaoDeObra;
    private @ManyToOne TipoServico tipoServico;
    private @ManyToOne OrdemDeServico ordemDeServico;
}
