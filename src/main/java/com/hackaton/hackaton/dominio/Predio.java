package com.hackaton.hackaton.dominio;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Predio {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 255)
	private String rua;

	@Column(length = 10)
	private String cep;

	@Column(length = 100)
	private String cidade;

	@Column(length = 100)
	private String estado;

	// Relacionamento com amenidades (1:1)
	@OneToMany(mappedBy = "predio", cascade = CascadeType.ALL)
	private List<Amenidade> amenidades = new ArrayList<>();

	// Relacionamento com quartos (1:N)
	@OneToMany(mappedBy = "predio", cascade = CascadeType.ALL)
	private List<Quarto> quartos;

	// Relacionamento com produtos (1:N)
	@OneToMany(mappedBy = "predio", cascade = CascadeType.ALL)
	private List<Produto> produtos;

	// Relacionamento com serviços (1:N)
	@OneToMany(mappedBy = "predio", cascade = CascadeType.ALL)
	private List<Servico> servicos;

	protected Predio() {}

	public Predio(String rua, String cep, String cidade, String estado) {
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public UUID getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public List<Amenidade> getAmenidades() {
		return amenidades;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setAmenidades(List<Amenidade> amenidades) {
		this.amenidades = amenidades;
	}

	public void addAmenidades(Amenidade amenidade) {
		this.amenidades.add(amenidade);
	}


}