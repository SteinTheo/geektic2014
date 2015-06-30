package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Geek;

public class GeekDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Geek> selectAll() {
		List<Geek> geeks = em.createQuery("Select g from Geek g").getResultList();
		return geeks;
	}
}
