package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Data
@Entity
public class OrdemDeServico {
    private @Id @GeneratedValue Integer nroOrdemDeServico;
    private Date dataOrdemServico;
    private @ManyToOne Cliente cliente;
    private @ManyToOne Veiculo veiculo;
}
