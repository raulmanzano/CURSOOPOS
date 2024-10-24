package es.uniovi.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import es.uniovi.config.SpringConfig;


@Service
public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto
			=new AnnotationConfigApplicationContext(SpringConfig.class);
		Aplicacion aplicacion=contexto.getBean("aplicacion", Aplicacion.class);
		aplicacion.run();
	}
	
	
}
