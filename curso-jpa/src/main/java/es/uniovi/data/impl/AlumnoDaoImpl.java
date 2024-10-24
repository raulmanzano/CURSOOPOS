package es.uniovi.data.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.data.AlumnoDao;
import es.uniovi.domain.Alumno;

@Repository	
@Transactional
public class AlumnoDaoImpl implements AlumnoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Alumno insertar(Alumno alumno) {
		entityManager.persist(alumno);
		return alumno;
	}

	public Collection<Alumno> findAll() {
		return entityManager.createQuery("select a from Alumno a").getResultList();
	}
	
	public Collection<Alumno> porNombre(String nombre) {
		return entityManager.createNamedQuery(Alumno.ALUMNO_POR_NOMBRE, Alumno.class)
					.setParameter("nombre", nombre)
					.getResultList();
	}
}
