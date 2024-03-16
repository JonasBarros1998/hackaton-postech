package com.hackaton.hackaton.view.forms;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record AmenidadesForm(
	@NotEmpty(message = "O atributo nome e obrigatorio")
	@Min(value = 10, message = "O atributo nome deve conter pelo menos 10")
	@Max(value = 100, message = "O atributo nome deve conter no maximo 100")
	String nome,

	@NotEmpty(message = "O atributo descricao e obrigatorio")
	@Min(value = 10, message = "O atributo descricao deve conter pelo menos 10")
	@Max(value = 200, message = "O atributo descricao deve conter no maximo 200")
	String descricao
) {}