package com.es1.api.repositorio;

import com.es1.api.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    Cliente findByCpfCliente(String cpfCliente);

}
