package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Banheiro {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 200)
	private String descricao;

	@Column
	private Integer quantidade;

	// Relacionamento com quarto (N:1)
	@ManyToOne
	@JoinColumn(name = "quarto_id")
	private Quarto quarto;

	public Banheiro() {}

	public Banheiro(String descricao, Integer quantidade) {
		this.descricao = descricao;
		this.quantidade = quantidade;
	}


	public String getDescricao() {
		return descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public UUID getId() {
		return id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}
