package org.jee.zoo.animal.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jee.zoo.animal.model.Animal;
import org.jee.zoo.animal.model.AnimalReduced;
import org.jee.zoo.dao.JpaDao;

public class AnimalDao extends JpaDao<String, Animal> implements IAnimalDao {

	@Inject
	private Logger log;

	@Inject
	EntityManager em;

	@Override
	public List<Animal> findAll() {
		return findAllAnimal();
	}

	@Override
	public Animal findById(int id) {
		return em.find(Animal.class, id);
	}

	@Override
	public Animal findByName(String name) {
		return em.find(Animal.class, name);
	}

	@Override
	public List<Animal> findAllAnimal() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Animal> criteria = cb.createQuery(Animal.class);
		Root<Animal> animal = criteria.from(Animal.class);
		criteria.select(animal).orderBy(cb.asc(animal.get("name")));
		List<Animal> tata = em.createQuery(criteria).getResultList();
		System.out.println("list animal: " + tata.size());
		return tata;
		// return em.createQuery(criteria).getResultList();
	}

	@Override
	public void register(Animal animal) throws Exception {
		log.info("Persisting " + animal.getName());
		em.persist(animal);
	}

	@Override
	public List<AnimalReduced> findAllAnimalReduced() {
		// TODO Auto-generated method stub
		return null;
	}

}