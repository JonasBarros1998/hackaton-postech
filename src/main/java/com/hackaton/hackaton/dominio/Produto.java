package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 100)
	private String nome;


	@Column
	private Integer quantidade;

	@Column(precision = 5, scale = 2)
	private BigDecimal preco;

	@Transient
	private Integer quantidadeComprada;

	// Relacionamento com predio (N:1)
	@ManyToOne
	@JoinColumn(name = "predio_id")
	private Predio predio;

	protected Produto() {}

	public Produto(String nome, BigDecimal preco, Integer quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getQuantidadeComprada() {
		return quantidadeComprada;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public void addQuantidadeComprada(Integer quantidade) {
		this.quantidadeComprada = quantidade;
	}


}