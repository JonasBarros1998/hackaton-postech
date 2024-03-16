package com.hackaton.hackaton.infra;

import com.hackaton.hackaton.dominio.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
}
