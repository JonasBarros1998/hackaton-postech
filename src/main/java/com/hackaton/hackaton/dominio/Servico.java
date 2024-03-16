package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 100)
	private String nome;

	@Column(precision = 5, scale = 2)
	private BigDecimal preco;

	@Transient
	private Integer quantidadeComprada;

	// Relacionamento com predio (N:1)
	@ManyToOne
	@JoinColumn(name = "predio_id")
	private Predio predio;


	protected Servico() {}

	public Servico(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getQuantidadeComprada() {
		return quantidadeComprada;
	}

	public Predio getPredio() {
		return predio;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void addQuantidadeComprada(Integer quantidade) {
		this.quantidadeComprada = quantidade;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}
}
