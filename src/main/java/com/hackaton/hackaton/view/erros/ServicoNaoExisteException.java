package com.hackaton.hackaton.view.erros;

public class ServicoNaoExisteException extends RuntimeException {
	public ServicoNaoExisteException(String mensagem) {
		super(mensagem);
	}
}
