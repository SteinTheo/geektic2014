package model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class InteretDao {
	private EntityManager em;
	private static final String JPA_NAME = "GEEKTIC";
	
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory(
					JPA_NAME).createEntityManager();
		}
		return em;
	}
}
