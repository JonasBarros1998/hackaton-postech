package com.hackaton.hackaton.view.forms;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record BanheiroForm(
	@NotEmpty(message = "O atributo descricao é obrigatório")
	@Length(min = 10, max = 200, message = "O atributo descricao deve conter entre 10 e 200 caracteres")
	String descricao,

	@NotNull(message = "O atributo quantidade é obrigatório")
	Integer quantidade
) {}
