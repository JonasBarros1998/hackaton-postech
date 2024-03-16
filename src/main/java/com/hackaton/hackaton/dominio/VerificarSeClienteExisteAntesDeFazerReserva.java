package com.hackaton.hackaton.dominio;

import java.util.Optional;

public class VerificarSeClienteExisteAntesDeFazerReserva {

	public static Boolean verificar(Optional<Cliente> cliente) {
		return cliente.isPresent();
	}
}
