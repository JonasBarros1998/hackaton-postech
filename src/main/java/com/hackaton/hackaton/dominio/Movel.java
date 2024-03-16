package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Movel {


	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 70)
	private String nome;

	@Column
	private Integer quantidade;

	// Relacionamento com quarto (N:1)
	@ManyToOne
	@JoinColumn(name = "quarto_id")
	private Quarto quarto;

	protected Movel() {}

	public Movel(String nome, Integer quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public UUID getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}