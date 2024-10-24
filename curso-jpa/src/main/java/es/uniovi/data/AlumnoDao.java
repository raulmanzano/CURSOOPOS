package es.uniovi.data;

import java.util.Collection;

import es.uniovi.domain.Alumno;

public interface AlumnoDao {

	
	public Alumno insertar(Alumno alumno);
	
	public Collection<Alumno> findAll();
	
	public Collection<Alumno> porNombre(String nombre);
}
