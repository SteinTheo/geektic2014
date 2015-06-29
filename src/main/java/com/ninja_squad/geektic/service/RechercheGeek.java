package com.ninja_squad.geektic.service;
import java.awt.List;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.ninja_squad.geektic.config.AppConfig;
import entity.Geek;

public class RechercheGeek {
	
	List<Geek> resultat;
	
	public List<Geek> findByNom(String name){
		DriverManagerDataSource database = new DriverManagerDataSource("jdbc:hsqldb:hsql://localhost/GEEKTIC", "sa", "");
        database.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        
        
	}
}
