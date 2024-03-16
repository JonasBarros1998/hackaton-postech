package com.hackaton.hackaton.infra;

import com.hackaton.hackaton.dominio.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PredioRepository extends JpaRepository<Predio, UUID> {
}
