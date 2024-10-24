package es.uniovi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import es.uniovi.SpringConfig;
import es.uniovi.service.SaludoService;

@Service
public class Main {
	
	@Autowired
	private SaludoService saludoService;

	public SaludoService getSaludoService() {
		return saludoService;
	}

	public void setSaludoService(SaludoService saludoService) {
		this.saludoService = saludoService;
	}


	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto
			=new AnnotationConfigApplicationContext(SpringConfig.class);
		Main main=contexto.getBean("main", Main.class);
		main.run();
	}
	
	
	public void run() {
		System.out.println(saludoService.obtenerSaludo("mundo"));
	}

}
