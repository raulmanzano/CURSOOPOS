package es.uniovi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.uniovi.service.SaludoService;
import es.uniovi.service.impl.DefaultSaludoService;

public class Main {
	
	private SaludoService saludoService;

	public SaludoService getSaludoService() {
		return saludoService;
	}

	public void setSaludoService(SaludoService saludoService) {
		this.saludoService = saludoService;
	}


	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml"); 
		((Main)context.getBean("main")).run();
	}
	
	
	public void run() {
		System.out.println(saludoService.obtenerSaludo("mundo"));
	}

}
