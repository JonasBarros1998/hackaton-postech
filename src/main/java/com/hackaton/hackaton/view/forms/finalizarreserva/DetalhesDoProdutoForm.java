package com.hackaton.hackaton.view.forms.finalizarreserva;

import java.util.UUID;

public record DetalhesDoProdutoForm(
	UUID id,
	String nome,
	Integer quantidade
) {
}
