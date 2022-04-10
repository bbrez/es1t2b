package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class OrdemDeServico {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer nroOrdemDeServico;
    private Date dataOrdemServico;
    private @ManyToOne(cascade = CascadeType.ALL) Cliente cliente;
    private @ManyToOne(cascade = CascadeType.ALL) Veiculo veiculo;
}
