package com.hackaton.hackaton.entradas;

import com.hackaton.hackaton.dominio.Quarto;
import com.hackaton.hackaton.dominio.Reserva;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarQuartoForm;
import com.hackaton.hackaton.view.forms.ConsultarQuartosForm;
import com.hackaton.hackaton.view.forms.QuartoForm;

import java.util.List;
import java.util.UUID;

public interface IGerenciarQuartos {

	public QuartoForm adicionar(QuartoForm quartoForm);

	Quarto consultar(UUID idDoQuarto);

	List<QuartoForm> consultar(ConsultarQuartosForm consultarQuartosForm);

	List<Quarto> atualizarQuantidadeDeQuartos(List<Reserva> reservas);

	void remover(UUID idDoQuarto);

	AtualizarQuartoForm editar(AtualizarQuartoForm quartoForm, UUID idDoQuarto);

}
