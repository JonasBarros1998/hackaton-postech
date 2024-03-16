package com.hackaton.hackaton.view.forms;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public record MovelForm(
	@NotEmpty(message = "O atributo nome é obrigatório")
	@Length(min = 10, max = 70, message = "O atributo nome deve conter entre 10 e 70 caracteres")
	String nome,

	@NotNull(message = "O atributo quantidade e obrigatorio")
	Integer quantidade
) {}
