package org.jee.zoo.dao;

import java.util.List;

/**
 * @author Gerald Interface qui sert de modèle, pour le stockage d'objet
 *         "modèles" dans la base de données
 * 
 *         K is type of the Key (usually Long or String) E is the type of entity
 *         managed by this DAO
 */
public interface Dao<K, E> {
	void persist(E entity);

	void remove(E entity);

	E findById(K id);

	List<E> findAll();
}