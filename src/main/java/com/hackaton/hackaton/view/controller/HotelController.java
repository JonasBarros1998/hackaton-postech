package com.hackaton.hackaton.view.controller;

import com.hackaton.hackaton.aplicacao.IGerenciarServicos;
import com.hackaton.hackaton.dominio.Servico;
import com.hackaton.hackaton.entradas.IGerenciarPredio;
import com.hackaton.hackaton.entradas.IGerenciarProdutos;
import com.hackaton.hackaton.entradas.IGerenciarQuartos;
import com.hackaton.hackaton.view.forms.*;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarPredioForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarProdutoForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarQuartoForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarServicoForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class HotelController {

	IGerenciarQuartos gerenciarQuartos;

	IGerenciarPredio gerenciarPredio;

	IGerenciarProdutos gerenciarProdutos;

	IGerenciarServicos gerenciarServicos;

	@Autowired
	public HotelController(
		IGerenciarQuartos gerenciarQuartos,
		IGerenciarPredio gerenciarPredio,
		IGerenciarServicos gerenciarServicos,
		IGerenciarProdutos gerenciarProdutos) {
		this.gerenciarQuartos = gerenciarQuartos;
		this.gerenciarPredio = gerenciarPredio;
		this.gerenciarServicos = gerenciarServicos;
		this.gerenciarProdutos = gerenciarProdutos;
	}

	@PostMapping("/predios")
	public ResponseEntity<PredioForm> adicionarPredio(@RequestBody @Valid PredioForm predioForm) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarPredio.adicionar(predioForm));
	}

	@GetMapping("/predios")
	public ResponseEntity<List<PredioForm>> consultarPredio() {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarPredio.consultar());
	}

	@PutMapping("/predios/{id}")
	public ResponseEntity<AtualizarPredioForm> atualizarPredio(@Valid @RequestBody AtualizarPredioForm predioForm, @PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.gerenciarPredio.atualizar(predioForm, id));
	}

	@DeleteMapping("/predios/{id}")
	public ResponseEntity<Void> RemoverPredio(@PathVariable UUID id) {
		this.gerenciarPredio.remover(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}



	@PostMapping("/quartos")
	public ResponseEntity<QuartoForm> adicionarQuarto(@RequestBody @Valid QuartoForm quartoForm) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarQuartos.adicionar(quartoForm));
	}

	@PostMapping("/quartos/consultar")
	public ResponseEntity<List<QuartoForm>> consultarQuartos(@Valid @RequestBody ConsultarQuartosForm consultarQuartosForm) {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(this.gerenciarQuartos.consultar(consultarQuartosForm));
	}

	@PutMapping("/quartos/{id}")
	public ResponseEntity<AtualizarQuartoForm> atualizarQuarto(
		@Valid @RequestBody AtualizarQuartoForm atualizarQuartoForm,
		@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.gerenciarQuartos.editar(atualizarQuartoForm, id));
	}

	@DeleteMapping("/quartos/{id}")
	public ResponseEntity<Void> removerQuarto(@PathVariable UUID id) {
		this.gerenciarQuartos.remover(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}



	@PostMapping("/produtos")
	public ResponseEntity<ProdutoForm> adicionarProdutos(@RequestBody @Valid ProdutoForm produtoForm) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarProdutos.adicionar(produtoForm));
	}

	@PutMapping("/produtos/{id}")
	public ResponseEntity<AtualizarProdutoForm> atualizarProdutos(
		@RequestBody @Valid AtualizarProdutoForm produtoForm,
		@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarProdutos.editar(id, produtoForm));
	}

	@GetMapping("/produtos")
	public ResponseEntity<List<ProdutoForm>> consultarProdutoPorId() {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarProdutos.consultar());
	}

	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Void> removerProduto(@PathVariable UUID id) {
		this.gerenciarProdutos.remover(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}



	@PostMapping("/servicos")
	public ResponseEntity<ServicoForm> adicionarServico(@RequestBody @Valid ServicoForm servicoForm) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.gerenciarServicos.adicionar(servicoForm));
	}

	@PutMapping("/servicos/{id}")
	public ResponseEntity<AtualizarServicoForm> atualizarServico(@RequestBody @Valid AtualizarServicoForm atualizarServico, @PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.gerenciarServicos.atualizar(id, atualizarServico));
	}

	@GetMapping("/servicos")
	public ResponseEntity<List<ServicoForm>> consultarServico() {
		return ResponseEntity.status(HttpStatus.OK).body(this.gerenciarServicos.consultar());
	}

	@DeleteMapping("/servicos/{id}")
	public ResponseEntity<Void> removerServico(@PathVariable UUID id) {
		this.gerenciarServicos.remover(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
