package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Amenidade {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 100)
	private String nome;

	@Column(length = 200)
	private String descricao;

	// Relacionamento com predio (1:1)
	@ManyToOne
	@JoinColumn(name = "predio")
	private Predio predio;

	protected Amenidade() {}

	public Amenidade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public UUID getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
}
