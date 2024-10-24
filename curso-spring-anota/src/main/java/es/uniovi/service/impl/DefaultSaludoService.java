package es.uniovi.service.impl;

import org.springframework.stereotype.Service;

import es.uniovi.service.SaludoService;

@Service
public class DefaultSaludoService implements SaludoService {
	
	private String saludo="Hola";

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public String obtenerSaludo(String nombre) {
		return saludo + " "  + nombre + " !";
	}
	
	
	

}
