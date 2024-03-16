package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.Amenidade;
import com.hackaton.hackaton.dominio.Predio;
import com.hackaton.hackaton.entradas.IGerenciarPredio;
import com.hackaton.hackaton.infra.PredioRepository;
import com.hackaton.hackaton.view.forms.AmenidadesForm;
import com.hackaton.hackaton.view.forms.PredioForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarPredioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GerenciarPredios implements IGerenciarPredio {

	PredioRepository predioRepository;

	@Autowired
	GerenciarPredios(PredioRepository predioRepository) {
		this.predioRepository = predioRepository;
	}


	public AtualizarPredioForm atualizar(AtualizarPredioForm predioForm, UUID id) {
		Predio predio = this.predioRepository.findById(id).orElseThrow(null);
		List<Amenidade> amenidades = new ArrayList<>();

		predio.setCep(predioForm.cep());
		predio.setEstado(predioForm.estado());
		predio.setCidade(predioForm.cidade());
		predio.setRua(predioForm.rua());

		predioForm.amenidades().forEach(amenidadeForm ->
			predio.getAmenidades().forEach(amenidade -> {
				if(amenidade.getId().toString().equals(amenidadeForm.id().toString())) {
					amenidade.setNome(amenidadeForm.nome());
					amenidade.setDescricao(amenidadeForm.descricao());
					amenidades.add(amenidade);
				}
			})
		);

		predio.setAmenidades(amenidades);
		this.predioRepository.save(predio);

		return predioForm;
	}

	public void remover(UUID id) {
		this.predioRepository.deleteById(id);
	}

	public PredioForm adicionar(PredioForm predioForm) {

		var predio = new Predio(predioForm.rua(), predioForm.cep(), predioForm.cidade(), predioForm.estado());

		predioForm.amenidades()
			.forEach(amenidadeForm -> {
				var amenidade = new Amenidade(amenidadeForm.nome(), amenidadeForm.descricao());
				amenidade.setPredio(predio);
				predio.addAmenidades(amenidade);
			});

		predioRepository.save(predio);

		return predioForm;
	}

	public List<PredioForm> consultar() {
		return this.predioRepository.findAll().stream().map(item -> {

			var amenidades = item.getAmenidades().stream().map(amenidadeItem ->
				new AmenidadesForm(amenidadeItem.getNome(), amenidadeItem.getDescricao())
			).toList();

			return new PredioForm(
				item.getId(),
				item.getRua(),
				item.getCep(),
				item.getCidade(),
				item.getEstado(),
				amenidades
			);
		}).toList();

	}


}
