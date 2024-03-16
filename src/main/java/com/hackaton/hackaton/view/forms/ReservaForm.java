package com.hackaton.hackaton.view.forms;

import com.hackaton.hackaton.view.forms.finalizarreserva.CriarReservaProdutoForm;
import com.hackaton.hackaton.view.forms.finalizarreserva.CriarReservaServicoForm;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ReservaForm(

	@NotNull(message = "O atributo dataEntrada e obrigatorio")
	LocalDate dataEntrada,

	@NotNull(message = "O atributo dataSaida e obrigatorio")
	LocalDate dataSaida,

	@NotNull(message = "O atributo quantidadeDePessoas e obrigatorio")
	Integer quantidadeDePessoas,

	@NotNull(message = "O atributo quantidadeDeQuartos e obrigatorio")
	Integer quantidadeDeQuartos,

	@NotNull(message = "o campo idDoQuarto e obrigatorio")
	UUID idDoQuarto,

	List<CriarReservaServicoForm> servico,

	List<CriarReservaProdutoForm> produto
) {}
