package org.jee.zoo.animal.dao;

import java.util.List;

import org.jee.zoo.animal.model.Animal;
import org.jee.zoo.animal.model.AnimalReduced;
import org.jee.zoo.dao.Dao;

/**
 * 
 * @author ger
 * @see Dao
 * This interface will be used to persist data for Animal, using Generic Dao Pattern.
 */
public interface IAnimalDao extends Dao<String,Animal>{
	
	Animal findById(int id);

	Animal findByName(String name);

	List<Animal> findAllAnimal();

	void register(Animal member) throws Exception;

	List<AnimalReduced> findAllAnimalReduced();
	
}
