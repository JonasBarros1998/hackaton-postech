package com.hackaton.hackaton.view.forms;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record QuartoForm(

	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	UUID id,

	@NotNull(message = "O atributo quantidade e obrigatorio")
	Integer quantidade,

	@NotEmpty(message = "O atributo tipo é obrigatório")
	@Length(min = 10, max = 100, message = "O atributo tipo deve conter entre 10 e 100 caracteres")
	String tipo,

	@NotNull(message = "O atributo totalDePessoas é obrigatório")
	Integer totalDePessoas,

	@NotNull(message = "O atributo valorDaDiaria é obrigatório")
	BigDecimal valorDaDiaria,

	@Valid
	List<MovelForm> moveis,

	@Nullable
	PredioForm predio,

	@Valid
	List<BanheiroForm> banheiros,

	@NotNull
	UUID predioId
) {}
