package com.hackaton.hackaton.entradas;

import com.hackaton.hackaton.view.forms.PredioForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarPredioForm;

import java.util.List;
import java.util.UUID;

public interface IGerenciarPredio {

	PredioForm adicionar(PredioForm predioForm);

	AtualizarPredioForm atualizar(AtualizarPredioForm predioForm, UUID id);

	void remover(UUID id);

	public List<PredioForm> consultar();
}
