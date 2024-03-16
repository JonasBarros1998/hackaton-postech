package com.hackaton.hackaton.view.erros;

public class ProdutoNaoExisteException extends RuntimeException {

	public ProdutoNaoExisteException(String mensagem) {
		super(mensagem);
	}

}
