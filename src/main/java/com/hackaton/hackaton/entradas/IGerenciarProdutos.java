package com.hackaton.hackaton.entradas;

import com.hackaton.hackaton.dominio.Produto;
import com.hackaton.hackaton.dominio.Reserva;
import com.hackaton.hackaton.view.forms.ProdutoForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarProdutoForm;

import java.util.List;
import java.util.UUID;

public interface IGerenciarProdutos {
	void atualizarQuantidadeDeProdutos(List<Reserva> reservas);

	Produto consultar(UUID id);

	List<ProdutoForm> consultar();

	ProdutoForm consultarProduto(UUID id);

	ProdutoForm adicionar(ProdutoForm produtoForm);

	AtualizarProdutoForm editar(UUID id, AtualizarProdutoForm produtoForm);

	void remover(UUID id);

}
