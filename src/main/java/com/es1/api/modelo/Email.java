package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Email {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer idEmail;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
}
