package com.hackaton.hackaton.infra;

import com.hackaton.hackaton.dominio.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
