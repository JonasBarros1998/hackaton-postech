package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.Cliente;
import com.hackaton.hackaton.entradas.IGerenciarCliente;
import com.hackaton.hackaton.infra.ClientesRepository;
import com.hackaton.hackaton.view.forms.ClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GestaoDeClientes implements IGerenciarCliente {

	ClientesRepository clientesRepository;

	@Autowired
	public GestaoDeClientes(ClientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}

	public ClienteForm salvar(ClienteForm clienteForm) {
		var cliente = new Cliente(
			clienteForm.paisDeOrigem(),
			clienteForm.cpf(),
			clienteForm.passaporte(),
			clienteForm.nomeCompleto(),
			clienteForm.dataNascimento(),
			clienteForm.telefone(),
			clienteForm.email(),
			clienteForm.rua(),
			clienteForm.estado(),
			clienteForm.cidade(),
			clienteForm.cep()
		);

		this.clientesRepository.save(cliente);
		return clienteForm;
	}

	public ClienteForm atualizar(UUID id, ClienteForm clienteForm) {

		Cliente cliente =  this.clientesRepository.findById(id).orElseThrow(null);

		cliente.setCep(clienteForm.cep());
		cliente.setCidade(clienteForm.cidade());
		cliente.setCpf(clienteForm.cpf());
		cliente.setEstado(clienteForm.estado());
		cliente.setRua(clienteForm.rua());
		cliente.setEmail(clienteForm.email());
		cliente.setDataNascimento(clienteForm.dataNascimento());
		cliente.setPaisDeOrigem(clienteForm.paisDeOrigem());
		cliente.setTelefone(clienteForm.telefone());
		cliente.setPassaporte(clienteForm.passaporte());
		cliente.setPaisDeOrigem(clienteForm.paisDeOrigem());
		cliente.setNomeCompleto(cliente.getNomeCompleto());

		this.clientesRepository.save(cliente);
		return clienteForm;
	}


	public void remover(UUID id) {
		this.clientesRepository.deleteById(id);
	}

	public List<ClienteForm> consultar() {
		return this.clientesRepository.findAll().stream().map(cliente ->
			new ClienteForm(
				cliente.getId(),
				cliente.getPaisDeOrigem(),
				cliente.getCpf(),
				cliente.getPassaporte(),
				cliente.getNomeCompleto(),
				cliente.getDataNascimento(),
				cliente.getRua(),
				cliente.getEstado(),
				cliente.getCidade(),
				cliente.getCep(),
				cliente.getTelefone(),
				cliente.getEmail()
			)
		).toList();
	}

}
