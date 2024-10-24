package es.uniovi.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.data.AlumnoDao;
import es.uniovi.data.PaisDao;
import es.uniovi.domain.Alumno;
import es.uniovi.domain.Pais;

@Component
public class Aplicacion {
	
	@Autowired
	private AlumnoDao alumnoDao;
	
	@Autowired
	private PaisDao paisDao;
	
	private Pais francia;
	private Pais italia;
	private Pais argentina;
	
	public void run() {		
		crearPaises();
		crearAlumnos();
		
		mostrarPais();
		
		mostrarAlumnos();

	}
	
	public void crearPaises() {
		francia=paisDao.insertar(new Pais("Francia"));
		italia=paisDao.insertar(new Pais("Italia"));
		argentina=paisDao.insertar(new Pais("Argentina"));
	}
	
	public void crearAlumnos() {
		alumnoDao.insertar(new Alumno("Pepe", francia));
		alumnoDao.insertar(new Alumno("Carmen", italia));
		alumnoDao.insertar(new Alumno("Juan", francia));
	}
	
	 
	@Transactional(readOnly=true)
	public void mostrarPais() {
		Pais pais=paisDao.find(1);
		System.out.println("Alumnos del pais " + pais.getNombre());
		for(Alumno a:pais.getAlumnos()) {
			System.out.println("Alumno : "  + a.getNombre());
		}
		
		System.out.println(" =========== Paises terminados en 'ia' ============");
		for(Pais p:paisDao.porNombre("%ia")) {
			System.out.println("Pais " + p.getNombre());
		}
	}
	
	public void mostrarAlumnos() {
		System.out.println("========== Alumnos terminados en n =========================");
		for(Alumno a:alumnoDao.porNombre("%n")) {
			System.out.println(a.getNombre());
		}
	}

}
