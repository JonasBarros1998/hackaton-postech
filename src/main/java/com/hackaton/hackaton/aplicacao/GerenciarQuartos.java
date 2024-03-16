package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.*;
import com.hackaton.hackaton.entradas.IGerenciarQuartos;
import com.hackaton.hackaton.infra.PredioRepository;
import com.hackaton.hackaton.infra.QuartoRepository;
import com.hackaton.hackaton.view.erros.QuartosIndisponiveisException;
import com.hackaton.hackaton.view.forms.*;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarQuartoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GerenciarQuartos implements IGerenciarQuartos {

	private QuartoRepository quartoRepository;
	private PredioRepository predioRepository;

	protected GerenciarQuartos() {}

	@Autowired
	GerenciarQuartos(QuartoRepository quartoRepository, PredioRepository predioRepository) {
		this.quartoRepository = quartoRepository;
		this.predioRepository = predioRepository;
	}

	public QuartoForm adicionar(QuartoForm quartoForm) {
		var quarto = new Quarto(quartoForm.tipo(), quartoForm.totalDePessoas(), quartoForm.valorDaDiaria(), quartoForm.quantidade());
		Predio predio = this.predioRepository.findById(quartoForm.predioId()).orElseThrow(null);

		quarto.setPredio(predio);

		var moveis = quartoForm.moveis()
			.stream()
			.map(movelForm -> {
				var movel = new Movel(movelForm.nome(), movelForm.quantidade());
				movel.setQuarto(quarto);
				return movel;
			}).toList();

		quarto.setMoveis(moveis);

		var banheiros = quartoForm.banheiros()
			.stream()
			.map(banheiroForm -> {
				var banheiro = new Banheiro(banheiroForm.descricao(), banheiroForm.quantidade());
				banheiro.setQuarto(quarto);
				return banheiro;
			}).toList();

		quarto.setBanheiros(banheiros);
		this.quartoRepository.save(quarto);

		return quartoForm;
	}

	public Quarto consultar(UUID idDoQuarto) {
		return this.quartoRepository
			.findById(idDoQuarto)
			.orElseThrow(() -> new QuartosIndisponiveisException("O quarto selecionado nao existe"));
	}

	public List<Quarto> atualizarQuantidadeDeQuartos(List<Reserva> reservas) {
		return reservas.stream().map(item -> {
			var quarto = this.consultar(item.getQuarto().getId());
			var novaQuantidade = CalcularQuantidadeDeQuartosDisponiveis.calcular(item, quarto);
			if (novaQuantidade < 0) {
				throw new QuartosIndisponiveisException("O quarto escolhido esta esgotado");
			}

			quarto.setQuantidade(novaQuantidade);

			this.quartoRepository.save(quarto);

			return quarto;
		}).toList();
	}

	public void remover(UUID idDoQuarto) {
		this.quartoRepository.deleteById(idDoQuarto);
	}

	public AtualizarQuartoForm editar(AtualizarQuartoForm quartoForm, UUID idDoQuarto) {

		var quartoSelecionado = this.quartoRepository.findById(idDoQuarto)
			.orElseThrow(() -> new RuntimeException("Quarto selecionado nao existe"));

		quartoSelecionado.setTipo(quartoForm.tipo());
		quartoSelecionado.setQuantidade(quartoForm.quantidade());
		quartoSelecionado.setTotalDePessoas(quartoForm.totalDePessoas());
		quartoSelecionado.setValorDaDiaria(quartoForm.valorDaDiaria());

		this.atualizarBanheiro(quartoSelecionado, quartoForm);

		this.atualizarMovel(quartoSelecionado, quartoForm);

		this.quartoRepository.save(quartoSelecionado);
		return quartoForm;
	}

	public List<QuartoForm> consultar(ConsultarQuartosForm consultarQuartosForm) {
		List<Quarto> quartos = this.quartoRepository.consultarQuartos(consultarQuartosForm.quantidadeDePessoas())
			.orElseThrow(() -> new QuartosIndisponiveisException("Quartos indisponiveis no momento"));

		return quartos.stream().map(item -> {

			var moveisForm = item.getMoveis()
				.stream()
				.map(movel -> new MovelForm(movel.getNome(), movel.getQuantidade()))
				.toList();

			var predioForm = new PredioForm(
				item.getPredio().getId(),
				item.getPredio().getRua(),
				item.getPredio().getCep(),
				item.getPredio().getCidade(),
				item.getPredio().getEstado(),
				null);

			var banheirosForm = item.getBanheiros()
				.stream()
				.map(banheiro -> new BanheiroForm(banheiro.getDescricao(), banheiro.getQuantidade()))
				.toList();

			return new QuartoForm(
				item.getId(),
				item.getQuantidade(),
				item.getTipo(),
				item.getTotalDePessoas(),
				item.getValorDaDiaria(),
				moveisForm,
				predioForm,
				banheirosForm,
				item.getPredio().getId());
		}).toList();

	}

	private void atualizarBanheiro(Quarto quartoSelecionado, AtualizarQuartoForm quartoForm) {

		quartoSelecionado.getBanheiros().forEach(banheiro ->
			quartoForm.banheiro().forEach(banheiroForm -> {

				if(banheiro.getId().toString().equals(banheiroForm.id().toString())) {
					banheiro.setDescricao(banheiroForm.descricao());
					banheiro.setQuantidade(banheiroForm.quantidade());
				}
			})
		);
	}

	private void atualizarMovel(Quarto quartoSelecionado, AtualizarQuartoForm quartoForm) {
		quartoSelecionado.getMoveis().forEach(movel ->
			quartoForm.movel().forEach(movelForm -> {

				if(movel.getId().toString().equals(movelForm.id().toString())) {
					movel.setNome(movelForm.nome());
					movel.setQuantidade(movelForm.quantidade());
				}
			})
		);
	}
}
