package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TipoServico {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idTipoServico;
    private @Column(nullable = false) String nomeTipoServico;
}
