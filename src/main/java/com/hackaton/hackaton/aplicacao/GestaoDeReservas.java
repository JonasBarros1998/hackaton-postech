package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.aplicacao.dto.FinalizaReservaDTO;
import com.hackaton.hackaton.dominio.*;
import com.hackaton.hackaton.entradas.IGestaoReservas;
import com.hackaton.hackaton.infra.QuartoRepository;
import com.hackaton.hackaton.infra.ReservaRepository;
import com.hackaton.hackaton.view.erros.ClienteNaoExisteException;
import com.hackaton.hackaton.view.erros.ReservaException;
import com.hackaton.hackaton.view.forms.*;
import com.hackaton.hackaton.view.forms.finalizarreserva.CriarReservaProdutoForm;
import com.hackaton.hackaton.view.forms.finalizarreserva.CriarReservaServicoForm;
import com.hackaton.hackaton.view.forms.finalizarreserva.FinalizarReservaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GestaoDeReservas implements IGestaoReservas {

	private final ReservaRepository reservaRepository;

	private final GerenciarQuartos gerenciarQuartos;

	private final QuartoRepository quartoRepository;

	private final SalvarReservaNoBancoDeDados salvarReservaNoBancoDeDados;

	private final ConsultarClienteNoBancoDeDados consultarClienteNoBancoDeDados;

	private final GerenciarProdutos gerenciarProdutos;

	private final GerenciarServicos gerenciarServicos;

	@Autowired
	GestaoDeReservas(
		ReservaRepository reservaRepository,
		QuartoRepository quartoRepository,
		GerenciarQuartos gerenciarQuartos,
		SalvarReservaNoBancoDeDados salvarReservaNoBancoDeDados,
		ConsultarClienteNoBancoDeDados consultarClienteNoBancoDeDados,
		GerenciarProdutos gerenciarProdutos,
		GerenciarServicos gerenciarServicos) {
		this.reservaRepository = reservaRepository;
		this.quartoRepository = quartoRepository;
		this.gerenciarQuartos = gerenciarQuartos;
		this.salvarReservaNoBancoDeDados = salvarReservaNoBancoDeDados;
		this.consultarClienteNoBancoDeDados = consultarClienteNoBancoDeDados;
		this.gerenciarProdutos = gerenciarProdutos;
		this.gerenciarServicos = gerenciarServicos;
	}

	@Override
	@Transactional
	public List<FinalizarReservaForm> criar(List<ReservaForm> reservasForm, UUID clienteId) {


		verificarSeOClienteExiste(clienteId);

		var reservas = reservasForm.stream().map(reservaForm -> {

				var quartoDoHotel = this.gerenciarQuartos.consultar(reservaForm.idDoQuarto());

				var reserva = new Reserva(
					reservaForm.dataEntrada(),
					reservaForm.dataSaida(),
					reservaForm.quantidadeDePessoas(),
					reservaForm.quantidadeDeQuartos(),
					BigDecimal.ZERO,
					Period.between(reservaForm.dataEntrada(), reservaForm.dataSaida()).getDays()
				);

				reserva.setQuarto(quartoDoHotel);
				reserva.setServicos(criarServico(reservaForm.servico()));
				reserva.setProduto(criarProduto(reservaForm.produto()));

				var calcularValorDeCadaReserva = CalcularValorDaReserva.calcular(reserva);

				reserva.setValorTotal(calcularValorDeCadaReserva);

				if(Boolean.TRUE.equals(VerificarAQuantidadeQuartosAntesDeFazerAReserva.verificar(quartoDoHotel))) {
					return reserva;
				}

				throw new ReservaException("Nao foi possivel concluir a reserva selecionada");

			}).toList();


		this.gerenciarQuartos.atualizarQuantidadeDeQuartos(reservas);

		this.gerenciarProdutos.atualizarQuantidadeDeProdutos(reservas);

		this.salvarReservaNoBancoDeDados.salvar(reservas);

		this.enviarEmail(clienteId);

		return this.montarDadosDeSaida(reservas);
	}

	private List<FinalizarReservaForm> montarDadosDeSaida(List<Reserva> reservas) {

		return reservas.stream().map(reserva -> {

			var moveisForm = FinalizaReservaDTO.converterMoveisParaMoveisForm(reserva.getQuarto().getMoveis());

			var predioForm = FinalizaReservaDTO.converterPredioParaPredioForm(reserva.getQuarto().getPredio());

			var banheirosForm = FinalizaReservaDTO.converterBanheiroParaBanheiroForm(reserva.getQuarto().getBanheiros());

			var produtosForm = FinalizaReservaDTO.converterProdutoParaProdutoForm(reserva.getProduto());

			var servicosForm = FinalizaReservaDTO.converterServicoParaServicoForm(reserva.getServicos());

			var quartoForm = new QuartoForm(
				reserva.getQuarto().getId(),
				reserva.getQuarto().getQuantidade(),
				reserva.getQuarto().getTipo(),
				reserva.getQuarto().getTotalDePessoas(),
				reserva.getQuarto().getValorDaDiaria(),
				moveisForm,
				predioForm,
				banheirosForm,
				null
			);

			return new FinalizarReservaForm(
				reserva.getValorTotal(),
				reserva.getDataEntrada(),
				reserva.getDataSaida(),
				quartoForm,
				servicosForm,
				produtosForm);

		}).toList();

	}

	public void verificarSeOClienteExiste(UUID clienteId) {
		Optional<Cliente> clienteConsultado = this.consultarClienteNoBancoDeDados.consultar(clienteId);
		if(Boolean.FALSE.equals(VerificarSeClienteExisteAntesDeFazerReserva.verificar(clienteConsultado))) {
			throw new ClienteNaoExisteException("Nao foi possivel concluir a reserva porque o cliente nao existe");
		}
	}

	private List<Servico> criarServico(List<CriarReservaServicoForm> servicos) {

		return servicos.stream()
			.map(item -> {
				var servico = this.gerenciarServicos.consultar(item.id());
				servico.addQuantidadeComprada(item.quantidade());
				return servico;
			})
			.toList();
	}

	private List<Produto> criarProduto(List<CriarReservaProdutoForm> produtos) {
		return produtos.stream()
			.map(item -> {
				var produto = this.gerenciarProdutos.consultar(item.id());
				produto.addQuantidadeComprada(item.quantidade());
				return produto;
			})
			.toList();
	}

	private void enviarEmail(UUID clienteId) {
		var cliente = this.consultarClienteNoBancoDeDados.consultar(clienteId).orElseThrow(null);
		EnviarEmailAoConfirmarReserva.enviar(cliente.getEmail());

	}

}

