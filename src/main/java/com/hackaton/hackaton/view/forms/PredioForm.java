package com.hackaton.hackaton.view.forms;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hackaton.hackaton.dominio.Amenidade;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

public record PredioForm(

	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	UUID id,

	@NotEmpty(message = "O atributo rua é obrigatório")
	@Length(min = 10, max = 100, message = "O atributo rua deve conter entre 10 e 100 caracteres")
	String rua,

	@NotEmpty(message = "O atributo cep é obrigatório")
	@Length(min = 8, max = 8, message = "O atributo cep deve conter 11 caracteres")
	String cep,

	@NotEmpty(message = "O atributo cidade é obrigatório")
	@Length(min = 5, max = 100, message = "O atributo cidade deve ter entre 10 e 100 caracteres")
	String cidade,

	@NotEmpty(message = "O atributo estado é obrigatório")
	@Length(min = 5, max = 100, message = "O atributo estado deve ter entre 10 e 100 caracteres")
	String estado,

	List<AmenidadesForm> amenidades
) {}
