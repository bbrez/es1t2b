package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DDD {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idDDD;
    private @Column(nullable = false) Integer numeroDDD;
}
