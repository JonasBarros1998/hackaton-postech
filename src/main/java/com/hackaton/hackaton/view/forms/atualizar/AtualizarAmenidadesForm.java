package com.hackaton.hackaton.view.forms.atualizar;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record AtualizarAmenidadesForm(
	@NotNull
	UUID id,

	@NotEmpty(message = "O atributo nome e obrigatorio")
	@Length(min = 5, max = 100, message = "O atributo nome deve conter pelo menos 100")
	String nome,

	@NotEmpty(message = "O atributo descricao e obrigatorio")
	@Length(min = 10, max = 200, message = "O atributo descricao deve conter pelo menos 10")
	String descricao
) {
}
