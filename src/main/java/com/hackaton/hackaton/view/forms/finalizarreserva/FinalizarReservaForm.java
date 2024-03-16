package com.hackaton.hackaton.view.forms.finalizarreserva;


import com.hackaton.hackaton.view.forms.QuartoForm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record FinalizarReservaForm(
	BigDecimal valorTotalDaReserva,

	LocalDate dataDeEntrada,
	LocalDate dataDeSaida,
	QuartoForm quartos,

	List<DetalhesServicoForm> detalhesDoServico,

	List<DetalhesDoProdutoForm> detalhesDoProduto
) {
}
