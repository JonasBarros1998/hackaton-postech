package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.Reserva;

import java.math.BigDecimal;

public class CalcularValorDaReserva {

	public static BigDecimal calcular(Reserva reserva) {

		var quartos = calcularValorDosQuartos(reserva);
		var produtos = calcularValorDosProdutos(reserva);
		var servicos = calcularValorDosServicos(reserva);

		return quartos.add(produtos).add(servicos);
	}

	private static BigDecimal calcularValorDosProdutos(Reserva reserva) {
			return reserva.getProduto().stream().map(produto ->
				produto
					.getPreco()
					.multiply(new BigDecimal(produto.getQuantidadeComprada()))
			).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private static BigDecimal calcularValorDosServicos(Reserva reserva) {
			return reserva.getServicos().stream().map(servico -> servico
				.getPreco()
				.multiply(new BigDecimal(servico.getQuantidadeComprada())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private static BigDecimal calcularValorDosQuartos(Reserva reserva) {
			return reserva.getQuarto()
				.getValorDaDiaria()
				.multiply(new BigDecimal(reserva.getQuantidadeDeQuartos()))
				.multiply(new BigDecimal(reserva.getQuantidadeDeDias()));
	}

}
