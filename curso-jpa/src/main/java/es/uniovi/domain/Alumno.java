package es.uniovi.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Alumno.ALUMNO_POR_NOMBRE,
			query="Select a from Alumno a where a.nombre like :nombre")
})
public class Alumno {
	
	public static final String ALUMNO_POR_NOMBRE = "alumno.porNombre";

	@Id @GeneratedValue
	private Integer id;
	
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pais pais;
	
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	public Alumno(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais=pais;
	}
	

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
