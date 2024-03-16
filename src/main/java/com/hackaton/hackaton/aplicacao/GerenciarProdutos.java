package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.CalcularQuantidadeDeAmenidadesDisponiveis;
import com.hackaton.hackaton.dominio.Predio;
import com.hackaton.hackaton.dominio.Produto;
import com.hackaton.hackaton.dominio.Reserva;
import com.hackaton.hackaton.entradas.IGerenciarProdutos;
import com.hackaton.hackaton.infra.PredioRepository;
import com.hackaton.hackaton.infra.ProdutoRepository;
import com.hackaton.hackaton.view.erros.ProdutoNaoExisteException;
import com.hackaton.hackaton.view.forms.ProdutoForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarProdutoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GerenciarProdutos implements IGerenciarProdutos {

	ProdutoRepository produtoRepository;

	PredioRepository predioRepository;

	@Autowired
	GerenciarProdutos(ProdutoRepository produtoRepository, PredioRepository predioRepository) {
		this.produtoRepository = produtoRepository;
		this.predioRepository = predioRepository;
	}

	public Produto consultar(UUID id) {
		return this.produtoRepository.findById(id)
			.orElseThrow(() -> new ProdutoNaoExisteException("O produto consultado nao existe"));
	}

	public List<ProdutoForm> consultar() {
		List<Produto> produtos = this.produtoRepository.findAll();

		return produtos.stream().map(produto ->
			new ProdutoForm(produto.getNome(), produto.getPreco(), produto.getId(), produto.getQuantidade())
		).toList();

	}

	public ProdutoForm consultarProduto(UUID id) {
		Produto produto = this.produtoRepository.findById(id)
			.orElseThrow(() -> new ProdutoNaoExisteException("O produto consultado nao existe"));

		return new ProdutoForm(produto.getNome(), produto.getPreco(), produto.getId(), produto.getQuantidade());
	}


	public ProdutoForm adicionar(ProdutoForm produtoForm) {
		Predio predio = this.predioRepository.findById(produtoForm.id()).orElseThrow(null);
		var produto = new Produto(produtoForm.nome(), produtoForm.preco(), produtoForm.quantidade());
		produto.setPredio(predio);
		this.produtoRepository.save(produto);
		return produtoForm;
	}


	public AtualizarProdutoForm editar(UUID id, AtualizarProdutoForm produtoForm) {
		Produto produto = this.consultar(id);

		produto.setQuantidade(produtoForm.quantidade());
		produto.setNome(produtoForm.nome());
		produto.setPreco(produtoForm.preco());

		this.produtoRepository.save(produto);

		return produtoForm;
	}


	public void atualizarQuantidadeDeProdutos(List<Reserva> reservas) {

		reservas.stream().forEach(reserva ->
			reserva.getProduto().stream().forEach(produto -> {

				var produtoSelecionado = this.consultar(produto.getId());

				var novaQuantidade = CalcularQuantidadeDeAmenidadesDisponiveis
					.produtos(produto.getQuantidadeComprada(), produtoSelecionado.getQuantidade());

				if(novaQuantidade < 0) {
					throw new ProdutoNaoExisteException("Nao esta diponivel a quantidade escolhida de produtos");
				}

				produtoSelecionado.setQuantidade(novaQuantidade);

				this.produtoRepository.save(produtoSelecionado);

			})
		);

	}

	public void remover(UUID id) {
		this.produtoRepository.deleteById(id);
	}
}
