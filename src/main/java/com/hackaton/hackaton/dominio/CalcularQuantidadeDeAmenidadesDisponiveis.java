package com.hackaton.hackaton.dominio;

import java.math.BigDecimal;

public class CalcularQuantidadeDeAmenidadesDisponiveis {

	public static Integer produtos(Integer quantidadeDeProdutosSelecionadas, Integer quantidadeDeProdutosDisponiveisNoEstoque) {

		return new BigDecimal(quantidadeDeProdutosDisponiveisNoEstoque)
			.subtract(new BigDecimal(quantidadeDeProdutosSelecionadas)).intValue();
	}

}
