package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.Predio;
import com.hackaton.hackaton.dominio.Servico;
import com.hackaton.hackaton.infra.PredioRepository;
import com.hackaton.hackaton.infra.ServicoRepository;
import com.hackaton.hackaton.view.erros.ServicoNaoExisteException;
import com.hackaton.hackaton.view.forms.ServicoForm;
import com.hackaton.hackaton.view.forms.atualizar.AtualizarServicoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GerenciarServicos implements IGerenciarServicos {

	ServicoRepository servicoRepository;
	PredioRepository predioRepository;

	@Autowired
	GerenciarServicos(ServicoRepository servicoRepository, PredioRepository predioRepository) {
		this.servicoRepository = servicoRepository;
		this.predioRepository = predioRepository;
	}

	public Servico consultar(UUID id) {
		return this.servicoRepository.findById(id)
			.orElseThrow(() -> new ServicoNaoExisteException("O servico consultado nao existe nesse hotel"));
	}

	public ServicoForm adicionar(ServicoForm servicoForm) {
		Predio predio = this.predioRepository.findById(servicoForm.predioId()).orElseThrow(null);

		var servico = new Servico(servicoForm.nome(), servicoForm.preco());

		servico.setPredio(predio);
		this.servicoRepository.save(servico);
		return servicoForm;
	}

	public void remover(UUID id) {
		this.servicoRepository.deleteById(id);
	}

	public AtualizarServicoForm atualizar(UUID id, AtualizarServicoForm servicoForm) {
		Servico servico = this.consultar(id);

		servico.setNome(servicoForm.nome());
		servico.setPreco(servicoForm.preco());

		this.servicoRepository.save(servico);

		return servicoForm;

	}

	public List<ServicoForm> consultar() {
		return this.servicoRepository.findAll()
			.stream()
			.map(servico ->
				new ServicoForm(servico.getPredio().getId(), servico.getId(), servico.getNome(), servico.getPreco(), null))
			.toList();
	}

}
