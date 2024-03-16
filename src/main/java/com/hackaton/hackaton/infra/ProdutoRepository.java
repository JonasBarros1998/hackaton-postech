package com.hackaton.hackaton.infra;

import com.hackaton.hackaton.dominio.Produto;
import com.hackaton.hackaton.dominio.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
