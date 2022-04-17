package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EstadoOS {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idEstado;
    private @Column(nullable = false) String nomeEstado;
}
