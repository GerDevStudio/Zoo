package org.jee.zoo.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * 
 * @author ger
 * @see Dao This class is the implementation of the interface Dao
 */
public abstract class JpaDao<K, E> implements Dao<K, E> {
	protected Class<E> entityClass;
	@Inject
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public JpaDao() {
		Type genericSuperClass = getClass().getGenericSuperclass();

	    ParameterizedType parametrizedType = null;
	    while (parametrizedType == null) {
	        if ((genericSuperClass instanceof ParameterizedType)) {
	            parametrizedType = (ParameterizedType) genericSuperClass;
	        } else {
	            genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
	        }
	    }

	    this.entityClass = (Class<E>) parametrizedType.getActualTypeArguments()[0];
		
		
//		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
//		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}

	public void persist(E entity) {
		entityManager.persist(entity);
	}

	public void remove(E entity) {
		entityManager.remove(entity);
	}

	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}
}
