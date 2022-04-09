package com.es1.api.modelo;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Veiculo {
    private @Id @GeneratedValue Integer idVeiculo;
    private String nomeVeiculo;
    private String placa;
    private String modelo;
    private Integer kmVeiculo;

    @OneToMany
    @JoinColumn(name = "idMarca")
    @ToString.Exclude
    private List<Marca> marca;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Veiculo veiculo = (Veiculo) o;
        return idVeiculo != null && Objects.equals(idVeiculo, veiculo.idVeiculo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
