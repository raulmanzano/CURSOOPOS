package es.uniovi.data;

import java.util.Collection;

import es.uniovi.domain.Pais;

public interface PaisDao {
	
	Pais insertar(Pais pais);
	
	Pais find(Integer id);
	
	Collection<Pais> porNombre(String nombre);
}
