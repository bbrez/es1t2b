package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DDI {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idDDI;
    private @Column(nullable = false) Integer numeroDDI;
}
