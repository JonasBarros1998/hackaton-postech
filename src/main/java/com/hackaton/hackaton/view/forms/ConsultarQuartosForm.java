package com.hackaton.hackaton.view.forms;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ConsultarQuartosForm(

	@NotNull(message = "O campo quantidadeDePessoas e obrigatorio")
	Integer quantidadeDePessoas,

	@NotNull(message = "O campo dataEntrada e obrigatorio")
	LocalDate dataEntrada,

	@NotNull(message = "O campo dataSaida e obrigatorio")
	LocalDate dataSaida
) {}
