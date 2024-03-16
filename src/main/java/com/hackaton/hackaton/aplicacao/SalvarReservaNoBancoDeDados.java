package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.dominio.Reserva;
import com.hackaton.hackaton.infra.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalvarReservaNoBancoDeDados {

	ReservaRepository reservaRepository;

	@Autowired
	public SalvarReservaNoBancoDeDados(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}

	public List<Reserva> salvar(List<Reserva> reservas) {
		return reservas.stream().map(reservaRepository::save).toList();
	}


}
