package com.hackaton.hackaton.view.forms.atualizar;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record AtualizarProdutoForm(
	@NotNull(message = "O atributo quantidade e obrigatorio")
	Integer quantidade,

	@NotEmpty(message = "O atributo produto e obrigatorio")
	String nome,

	@NotNull(message = "O atributo preco e obrigatorio")
	BigDecimal preco
) {
}
