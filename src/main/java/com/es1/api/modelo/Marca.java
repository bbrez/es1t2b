package com.es1.api.modelo;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class Marca {
    private @Id @GeneratedValue Integer idMarca;
    private String nomeMarca;
}
