package com.hackaton.hackaton.view.forms.atualizar;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;

public record AtualizarQuartoForm(

	@NotEmpty(message = "O atributo tipo e obrigatorio")
	@Length(min = 10, max = 100, message = "O atributo tipo deve conter entre 10 e 100 caracteres")
	String tipo,

	@NotNull(message = "O atributo totalDePessoas e obrigatorio")
	Integer totalDePessoas,

	@NotNull(message = "O atributo valorDaDiaria e obrigatorio")
	BigDecimal valorDaDiaria,

	@NotNull(message = "O atributo valorDaDiaria e obrigatorio")
	Integer quantidade,

	List<AtualizarBanheiroForm> banheiro,

	List<AtualizarMovelForm> movel
) {
}
