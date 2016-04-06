package org.jee.zoo.enclos.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.jee.zoo.enclos.dao.EnclosDao;
import org.jee.zoo.enclos.model.Enclos;

@RequestScoped
public class EnclosListProducer {

	@Inject
	EnclosDao enclosDao;
	
	private List<Enclos> enclos;
	
	@Produces
	@Named
	public List<Enclos>getEnclos() {
		System.out.println("temoin in getEnclos");
		return enclos;
	}
	
    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Enclos enclos) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
    	enclos= enclosDao.findAllEnclos();
    }
}

