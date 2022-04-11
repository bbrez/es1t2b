package com.es1.api.modelo;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Marca {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idMarca;
    private @Column(unique = true, nullable = false) String nomeMarca;
}
