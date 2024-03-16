package com.hackaton.hackaton.view.forms;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoForm(

	@Nullable
	String nome,

	@Nullable
	BigDecimal preco,

	@Nullable
	UUID id,

	@Nullable
	Integer quantidade
) {
}
