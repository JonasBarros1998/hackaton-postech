package com.hackaton.hackaton.entradas;

import com.hackaton.hackaton.view.forms.ReservaForm;
import com.hackaton.hackaton.view.forms.finalizarreserva.FinalizarReservaForm;

import java.util.List;
import java.util.UUID;

public interface IGestaoReservas {
	List<FinalizarReservaForm> criar(List<ReservaForm> reservasForm, UUID clienteId);
}
