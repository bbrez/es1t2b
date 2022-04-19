package com.es1.api.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class OrdemDeServico {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer nroOrdemDeServico;
    private Date dataOrdemServico;
    private @ManyToOne(cascade = CascadeType.MERGE) Cliente cliente;
    private @ManyToOne(cascade = CascadeType.MERGE) Veiculo veiculo;
    private @ManyToOne(cascade = CascadeType.MERGE) EstadoOS estado;
    private @OneToMany(mappedBy = "ordemDeServico") List<ItemProduto> produtoList;
    private @OneToMany(mappedBy = "ordemDeServico") List<Servico> servicoList;

    @JsonBackReference
    public List<ItemProduto> getProdutoList() {
        return produtoList;
    }

    @JsonBackReference
    public List<Servico> getServicoList() {
        return servicoList;
    }
}
