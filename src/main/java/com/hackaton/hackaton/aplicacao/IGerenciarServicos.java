package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.Servico;
import com.hackaton.hackaton.view.forms.ServicoForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarServicoForm;

import java.util.List;
import java.util.UUID;

public interface IGerenciarServicos {

	Servico consultar(UUID id);

	List<ServicoForm> consultar();

	ServicoForm adicionar(ServicoForm servicoForm);

	void remover(UUID id);

	AtualizarServicoForm atualizar(UUID id, AtualizarServicoForm servicoForm);
}
