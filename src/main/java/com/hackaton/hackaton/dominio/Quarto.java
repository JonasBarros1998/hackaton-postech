package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
public class Quarto {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 100)
	private String tipo;

	@Column
	private Integer totalDePessoas;

	@Column(precision = 5, scale = 2)
	private BigDecimal valorDaDiaria;

	@Column
	private Integer quantidade;


	@ManyToOne
	@JoinColumn(name = "predio_id")
	private Predio predio;


	@OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
	private List<Movel> moveis;


	@OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
	private List<Banheiro> banheiros;


	@OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
	private List<Reserva> reserva;


	protected Quarto() {}

	public Quarto(String tipo, Integer totalDePessoas, BigDecimal valorDaDiaria, Integer quantidade) {
		this.tipo = tipo;
		this.totalDePessoas = totalDePessoas;
		this.valorDaDiaria = valorDaDiaria;
		this.quantidade = quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public void setMoveis(List<Movel> moveis) {
		this.moveis = moveis;
	}

	public void setBanheiros(List<Banheiro> banheiros) {
		this.banheiros = banheiros;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setTotalDePessoas(Integer totalDePessoas) {
		this.totalDePessoas = totalDePessoas;
	}

	public void setValorDaDiaria(BigDecimal valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}

	public UUID getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public Integer getTotalDePessoas() {
		return totalDePessoas;
	}

	public BigDecimal getValorDaDiaria() {
		return valorDaDiaria;
	}

	public Predio getPredio() {
		return predio;
	}

	public List<Movel> getMoveis() {
		return moveis;
	}

	public List<Banheiro> getBanheiros() {
		return banheiros;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}


}
