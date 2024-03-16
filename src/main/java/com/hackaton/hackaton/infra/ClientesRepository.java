package com.hackaton.hackaton.infra;

import com.hackaton.hackaton.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientesRepository extends JpaRepository<Cliente, UUID> {
}
