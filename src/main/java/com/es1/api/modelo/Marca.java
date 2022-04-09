package com.es1.api.modelo;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Marca {
    private @Id @GeneratedValue Integer idMarca;
    private String nomeMarca;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Marca marca = (Marca) o;
        return idMarca != null && Objects.equals(idMarca, marca.idMarca);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
