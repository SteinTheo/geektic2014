package com.ninja_squad.geektic.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ninja_squad.geektic.dao.GeekDao;

import entity.Geek;

@Controller
public class GeekCtrl {
	
	@Autowired
	private GeekDao gDao;
	private List<Geek> geeks;
	
	public List<Geek> getGeeks(){
		if(geeks==null){
			geeks = gDao.selectAll();
		}
		return geeks;
	}
	
	public String getMessage(){
		return "Ceci est un test sur GeekCtrl";
	}
}
