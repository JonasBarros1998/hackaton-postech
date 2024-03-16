package com.hackaton.hackaton.view.forms.atualizar;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.UUID;
public record AtualizarMovelForm(

	@NotNull(message = "O atributo id e obrigatorio")
	UUID id,

	@NotEmpty(message = "O atributo nome é obrigatório")
	@Length(min = 10, max = 70, message = "O atributo nome deve conter entre 10 e 70 caracteres")
	String nome,

	@NotEmpty(message = "O atributo quantidade e obrigatorio")
	Integer quantidade
) {
}
