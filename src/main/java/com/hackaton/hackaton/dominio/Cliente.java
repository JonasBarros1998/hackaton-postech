package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String paisDeOrigem;

	@Column(nullable = true, unique = true)
	private String cpf;

	@Column(nullable = true, unique = true)
	private String passaporte;

	@Column(nullable = false)
	private String nomeCompleto;

	@Column(nullable = false)
	private LocalDate dataNascimento;

	@Column(nullable = true)
	private String rua;

	@Column(nullable = true)
	private String estado;

	@Column(nullable = true)
	private String cep;

	@Column(nullable = true)
	private String cidade;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String email;

	protected Cliente() {}

	public Cliente(String paisDeOrigem, String cpf, String passaporte, String nomeCompleto,
	               LocalDate dataNascimento, String telefone, String email, String rua, String estado, String cidade, String cep) {
		this.paisDeOrigem = paisDeOrigem;
		this.cpf = cpf;
		this.passaporte = passaporte;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.rua = rua;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
	}

	public UUID getId() {
		return id;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public String getCpf() {
		return cpf;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getRua() {
		return rua;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
