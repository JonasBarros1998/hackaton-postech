package com.hackaton.hackaton.infra;

import com.hackaton.hackaton.dominio.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuartoRepository extends JpaRepository<Quarto, UUID> {
	@Query("SELECT quarto FROM Quarto quarto WHERE quarto.totalDePessoas >= :totalDePessoas")
	Optional<List<Quarto>> consultarQuartos(Integer totalDePessoas);

}
