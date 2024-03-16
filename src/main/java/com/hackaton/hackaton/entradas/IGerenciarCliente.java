package com.hackaton.hackaton.entradas;

import com.hackaton.hackaton.view.forms.ClienteForm;

import java.util.List;
import java.util.UUID;

public interface IGerenciarCliente {
	ClienteForm salvar(ClienteForm clienteForm);

	ClienteForm atualizar(UUID id, ClienteForm clienteForm);

	void remover(UUID id);

	List<ClienteForm> consultar();
}
