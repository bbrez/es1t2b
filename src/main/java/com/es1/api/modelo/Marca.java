package com.es1.api.modelo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Marca {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idMarca;
    private String nomeMarca;
}
