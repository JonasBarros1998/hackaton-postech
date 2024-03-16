package com.hackaton.hackaton.aplicacao;

import com.hackaton.hackaton.infra.email.Email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class EnviarEmailAoConfirmarReserva {

	public static void enviar(String enviarPara) {
		final String emailHost = "fiappostech@gmail.com";
		final String senha = "dioo xoww dmdd jthn";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");


		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailHost, senha);
			}
		};
		Session session = Session.getInstance(props, auth);

		Email.enviar(session, enviarPara,"POSTECH", "RESERVA CONFIRMADA!!");
	}
}
