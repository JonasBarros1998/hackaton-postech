package com.hackaton.hackaton.dominio;

import com.hackaton.hackaton.dominio.Quarto;
import com.hackaton.hackaton.view.erros.QuartosIndisponiveisException;

public class VerificarAQuantidadeQuartosAntesDeFazerAReserva {

	public static Boolean verificar(Quarto quarto) {
		if(quarto.getQuantidade() >= 1) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
