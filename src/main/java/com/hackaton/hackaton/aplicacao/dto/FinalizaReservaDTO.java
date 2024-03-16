package com.hackaton.hackaton.aplicacao.dto;

import com.hackaton.hackaton.dominio.*;
import com.hackaton.hackaton.view.forms.BanheiroForm;
import com.hackaton.hackaton.view.forms.MovelForm;
import com.hackaton.hackaton.view.forms.PredioForm;
import com.hackaton.hackaton.view.forms.finalizarreserva.DetalhesDoProdutoForm;
import com.hackaton.hackaton.view.forms.finalizarreserva.DetalhesServicoForm;

import java.util.List;

public class FinalizaReservaDTO {

	private FinalizaReservaDTO() {}


	public static List<MovelForm> converterMoveisParaMoveisForm(List<Movel> moveis) {
		return moveis.stream()
			.map(item -> new MovelForm(item.getNome(), item.getQuantidade()))
			.toList();
	}

	public static PredioForm converterPredioParaPredioForm(Predio predio) {
		return new PredioForm(null, predio.getRua(), predio.getCep(), predio.getCidade(), predio.getEstado(), null);
	}

	public static List<BanheiroForm> converterBanheiroParaBanheiroForm(List<Banheiro> banheiros) {
		return banheiros.stream()
			.map(item -> new BanheiroForm(item.getDescricao(), item.getQuantidade()))
			.toList();
	}

	public static List<DetalhesDoProdutoForm> converterProdutoParaProdutoForm(List<Produto> produtos) {
		return produtos.stream()
			.map(item -> new DetalhesDoProdutoForm(item.getId(), item.getNome(), item.getQuantidade()))
			.toList();
	}

	public static List<DetalhesServicoForm> converterServicoParaServicoForm(List<Servico> servicos) {
		return servicos.stream()
			.map(item -> new DetalhesServicoForm(item.getId(), item.getNome()))
			.toList();
	}
}
