package com.es1.api.repositorio;

import com.es1.api.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    @Query("select c from Cliente c where c.cpfCliente = ?1")
    Cliente findByCpfCliente(String cpfCliente);

}
