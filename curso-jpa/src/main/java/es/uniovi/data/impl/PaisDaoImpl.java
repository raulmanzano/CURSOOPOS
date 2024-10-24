package es.uniovi.data.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.data.PaisDao;
import es.uniovi.domain.Pais;

@Repository
public class PaisDaoImpl implements PaisDao{
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Pais insertar(Pais pais) {
		em.persist(pais);
		return pais;
	}
	
	@Transactional(readOnly = true)
	public Pais find(Integer id) {
		return em.find(Pais.class, id);
	}
	
	public Collection<Pais> porNombre(String nombre) {
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaQuery<Pais> consulta=builder.createQuery(Pais.class);
		Root<Pais> rootPais=consulta.from(Pais.class);

		consulta.select(rootPais)
			.where(builder.like(rootPais.get("nombre").as(String.class), nombre));
		
		return em.createQuery(consulta).getResultList();

	}
	

}
