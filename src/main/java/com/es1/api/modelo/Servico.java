package com.es1.api.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Servico {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idServicos;
    private @ManyToOne(cascade = CascadeType.MERGE) TipoServico tipoServico;
    private @ManyToOne(cascade = CascadeType.MERGE) OrdemDeServico ordemDeServico;

    @JsonManagedReference
    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }
}