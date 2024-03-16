package com.hackaton.hackaton.view.forms.atualizar;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AtualizarServicoForm(
	@NotEmpty(message = "O atributo nome e obrigatorio")
	String nome,

	@NotNull(message = "O atributo preco e obrigatorio")
	BigDecimal preco
) {
}
