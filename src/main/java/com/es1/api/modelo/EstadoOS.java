package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class EstadoOS {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idEstado;
    private String nomeEstado;
}
