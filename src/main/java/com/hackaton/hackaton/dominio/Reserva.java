package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;
import jakarta.transaction.TransactionScoped;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private LocalDate dataEntrada;

	@Column(nullable = false)
	private LocalDate dataSaida;

	@Column(nullable = false)
	private Integer quantidadeDePessoas;

	@Column(nullable = false)
	private Integer quantidadeDeQuartos;

	@Column
	private Integer quantidadeDeDias;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "reservas")
	private Quarto quarto;

	@Transient
	private List<Produto> produto;

	@Transient
	private List<Servico> servicos;

	protected Reserva() {}

	public Reserva(LocalDate dataEntrada, LocalDate dataSaida, Integer quantidadeDePessoas,
	               Integer quantidadeDeQuartos, BigDecimal valorTotal, Integer quantidadeDeDias) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.quantidadeDePessoas = quantidadeDePessoas;
		this.quantidadeDeQuartos = quantidadeDeQuartos;
		this.valorTotal = valorTotal;
		this.quantidadeDeDias = quantidadeDeDias;
	}

	// Métodos Getters
	public UUID getId() {
		return id;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public Integer getQuantidadeDePessoas() {
		return quantidadeDePessoas;
	}

	public Integer getQuantidadeDeQuartos() {
		return quantidadeDeQuartos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public Integer getQuantidadeDeDias() {
		return quantidadeDeDias;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
