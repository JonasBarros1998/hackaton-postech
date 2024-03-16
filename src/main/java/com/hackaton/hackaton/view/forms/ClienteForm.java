package com.hackaton.hackaton.view.forms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;
import java.util.UUID;

public record ClienteForm(
	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	UUID id,

	@NotEmpty(message = "O atributo paisDeOrigem é obrigatório")
	@Length(min = 5, max = 100, message = "O atributo paisDeOrigem deve conter entre 10 e 100 caracteres")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String paisDeOrigem,

	@Length(min = 11, max = 11, message = "O atributo cpf deve conter 11 caracteres")
	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String cpf,

	@Length(min = 8, max = 8, message = "O atributo passaporte deve conter 8 caracteres")
	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String passaporte,

	@NotEmpty(message = "O atributo nomeCompleto é obrigatório")
	@Length(min = 10, max = 100, message = "O atributo nomeCompleto deve conter entre 10 e 100 caracteres")
	String nomeCompleto,

	@NotNull(message = "O atributo dataNascimento é obrigatório")
	LocalDate dataNascimento,

	@Nullable
	@Length(min = 10, max = 100, message = "O atributo endereco deve conter entre 10 e 100 caracteres")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String rua,

	@Length(min = 5, max = 100, message = "O atributo endereco deve conter entre 5 e 100 caracteres")
	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String estado,

	@Length(min = 5, max = 100, message = "O atributo endereco deve conter entre 5 e 100 caracteres")
	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String cidade,


	@Length(min = 8, max = 8, message = "O atributo endereco deve conter 8 caracteres")
	@Nullable
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String cep,

	@NotEmpty(message = "O atributo telefone e obrigatorio")
	@Length(min = 8, max = 13, message = "O atributo telefone deve conter entre 8 e 13 caracteres")
	String telefone,

	@NotEmpty(message = "O atributo email é obrigatório")
	@Length(min = 10, max = 100, message = "O atributo email deve conter entre 10 e 100 caracteres")
	String email
) {}