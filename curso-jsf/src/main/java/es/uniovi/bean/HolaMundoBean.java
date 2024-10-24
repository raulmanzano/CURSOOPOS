package es.uniovi.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class HolaMundoBean {
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {		
		this.nombre = nombre;
	}
	
	
	public String saludando() {
		if("Pepe".equals(nombre)) {
			return "saludaPepe";
		} else {
			return "saluda";
		}
	}
	
	
	public String getMayus() {
		if(nombre!=null) {
			return nombre.toUpperCase();
		} else {
			return null;
		}
	}
	

}
