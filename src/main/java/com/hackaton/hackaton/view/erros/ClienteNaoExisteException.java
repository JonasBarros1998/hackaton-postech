package com.hackaton.hackaton.view.erros;

public class ClienteNaoExisteException extends RuntimeException {
	public ClienteNaoExisteException(String message) {
		super(message);
	}

}
