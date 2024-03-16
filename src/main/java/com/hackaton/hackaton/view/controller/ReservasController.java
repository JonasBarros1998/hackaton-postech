package com.hackaton.hackaton.view.controller;

import com.hackaton.hackaton.aplicacao.GestaoDeClientes;
import com.hackaton.hackaton.entradas.IGestaoReservas;
import com.hackaton.hackaton.view.forms.ClienteForm;
import com.hackaton.hackaton.view.forms.ReservaForm;
import com.hackaton.hackaton.view.forms.finalizarreserva.FinalizarReservaForm;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ReservasController {
	IGestaoReservas gestaoReservas;

	@Autowired
	ReservasController(IGestaoReservas gestaoReservas) {
		this.gestaoReservas = gestaoReservas;
	}

	@PostMapping("/reservas/{id}")
	public ResponseEntity<List<FinalizarReservaForm>> cadastrarReserva(
		@Valid @RequestBody List<ReservaForm> clienteForm,
		@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gestaoReservas.criar(clienteForm, UUID.fromString(id)));
	}
}
