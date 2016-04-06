package org.jee.zoo.animal.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.jee.zoo.animal.dao.AnimalDao;
import org.jee.zoo.animal.model.Animal;

@RequestScoped
public class AnimalListProducer {

	@Inject
	AnimalDao animalDao;

	private List<Animal> animals;

	@Produces
	@Named
	public List<Animal> getAnimals() {
		System.out.println("temoin in getAnimals");
		return animals;
	}

	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Animal animal) {
		retrieveAllMembersOrderedByName();
	}

	@PostConstruct
	public void retrieveAllMembersOrderedByName() {
		animals = animalDao.findAllAnimal();
	}
}
