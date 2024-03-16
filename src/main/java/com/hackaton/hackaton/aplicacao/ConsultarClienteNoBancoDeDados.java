package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.Cliente;
import com.hackaton.hackaton.infra.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultarClienteNoBancoDeDados {

	private ClientesRepository clientesRepository;

	@Autowired
	ConsultarClienteNoBancoDeDados(ClientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}

	public Optional<Cliente> consultar(UUID clienteId) {
		return this.clientesRepository.findById(clienteId);
	}
}
