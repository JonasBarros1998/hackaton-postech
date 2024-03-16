package com.hackaton.hackaton.view.forms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.math.BigDecimal;
import java.util.UUID;

public record ServicoForm(
	@NotNull(message = "O atributo id e obrigatorio")
	UUID predioId,

	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	UUID id,

	@Nullable
	String nome,

	@Nullable
	BigDecimal preco,

	@Nullable
	Integer quantidadeComprada
) {}
