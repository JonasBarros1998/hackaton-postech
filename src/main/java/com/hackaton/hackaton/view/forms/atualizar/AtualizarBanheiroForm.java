package com.hackaton.hackaton.view.forms.atualizar;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record AtualizarBanheiroForm(

	@NotNull(message = "O atributo id e obrigatorio")
	UUID id,

	@NotEmpty(message = "O atributo descricao e obrigatorio")
	@Length(min = 10, max = 200, message = "O atributo descricao deve conter entre 10 e 200 caracteres")
	String descricao,

	@NotEmpty(message = "O atributo quantidade e obrigatorio")
	@Length(min = 10, max = 100, message = "O atributo quantidade deve conter entre 10 e 100 caracteres")
	Integer quantidade
) {
}
