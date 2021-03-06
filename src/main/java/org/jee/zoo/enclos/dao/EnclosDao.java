package org.jee.zoo.enclos.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jee.zoo.dao.JpaDao;
import org.jee.zoo.enclos.model.Enclos;

@ApplicationScoped
public class EnclosDao extends JpaDao<String, Enclos> implements IEnclosDao {

	@Inject
	EntityManager em;

	public List<Enclos> findAllEnclos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Enclos> criteria = cb.createQuery(Enclos.class);
		Root<Enclos> enclos = criteria.from(Enclos.class);
		criteria.select(enclos).orderBy(cb.asc(enclos.get("name")));
		List<Enclos> tata = em.createQuery(criteria).getResultList();
		System.out.println("list enclos: " + tata.size());
		return tata;
	}

	@Override
	public List<Enclos> findAll() {
		return findAllEnclos();
	}
}
