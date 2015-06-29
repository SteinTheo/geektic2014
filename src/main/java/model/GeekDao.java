package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entity.Geek;

public class GeekDao {
	private EntityManager em;
	private static final String JPA_NAME = "GEEKTIC";
	
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory(
					JPA_NAME).createEntityManager();
		}
		return em;
	}
	
	public List<Geek> selectAll(){
		List<Geek> geeks = getEntityManager().createQuery("Select g from Geek g").getResultList();
		return geeks;
	}
}
