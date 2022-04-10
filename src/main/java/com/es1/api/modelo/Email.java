package com.es1.api.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Email {
    private @Id @GeneratedValue Integer idEmail;
    private String email;
    private @ManyToOne Cliente cliente;
}
