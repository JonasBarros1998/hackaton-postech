package com.hackaton.hackaton.dominio;

import java.math.BigDecimal;

public class CalcularQuantidadeDeQuartosDisponiveis {

	public static Integer calcular(Reserva reserva, Quarto quartoDeQuartosDisponiveis) {
		return new BigDecimal(quartoDeQuartosDisponiveis.getQuantidade())
			.subtract(new BigDecimal(reserva.getQuantidadeDeQuartos())).intValue();
	}
}
