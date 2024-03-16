package com.hackaton.hackaton.view.controller;

import com.hackaton.hackaton.entradas.IGerenciarCliente;
import com.hackaton.hackaton.view.forms.ClienteForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

	IGerenciarCliente gerenciarCliente;

	@Autowired
	ClientesController(IGerenciarCliente gerenciarCliente) {
		this.gerenciarCliente = gerenciarCliente;
	}

	@PostMapping
	public ResponseEntity<ClienteForm> cadastrarCliente(@Valid @RequestBody ClienteForm clienteForm) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarCliente.salvar(clienteForm));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteForm> cadastrarCliente(
		@Valid @RequestBody ClienteForm clienteForm,
		@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.gerenciarCliente.atualizar(id, clienteForm));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteForm> cadastrarCliente(@PathVariable UUID id) {
		this.gerenciarCliente.remover(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping
	public ResponseEntity<List<ClienteForm>> cadastrarCliente() {
		return ResponseEntity.status(HttpStatus.OK).body(this.gerenciarCliente.consultar());
	}
}
