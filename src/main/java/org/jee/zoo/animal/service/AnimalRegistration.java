package org.jee.zoo.animal.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jee.zoo.animal.dao.AnimalDao;
import org.jee.zoo.animal.model.Animal;

@Stateless
public class AnimalRegistration implements IAnimalRegistration {

	@Inject
	private Logger log;

	@Inject
	private AnimalDao animalDao;

	@Inject
	private Event<Animal> animalEventSrc;

	@Override
	public void register(Animal animal) throws Exception {
		log.info("Registering " + animal.getName());
		animalDao.register(animal);
		animalEventSrc.fire(animal);
	}
}
