package control;

import java.util.List;

import model.GeekDao;
import entity.Geek;

public class GeekCtrl {
	private GeekDao gDao = new GeekDao();
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
