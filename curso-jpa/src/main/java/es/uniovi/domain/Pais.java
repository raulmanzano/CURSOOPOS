package es.uniovi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;


@Entity
public class Pais {
	
	@Id @GeneratedValue
	private Integer id;
	
	private String nombre;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="pais"  )
	private List<Alumno> alumnos=new ArrayList<Alumno>();
	
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public Pais() {
		// TODO Auto-generated constructor stub
	}

	public Pais(String nombre) {
		super();
		this.nombre = nombre;
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
	
	public String toString() {
		return "Pais " + this.id + ":" + this.nombre;
	}

}
