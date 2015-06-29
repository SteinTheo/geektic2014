package entity;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "INTERET")
public class Interet {
	
	int id;
	String nom;
	String type;
	
	@Id
	@Column(name = "ID_INT")
	@GeneratedValue
	public int getId(){
		return id;
	}
	
	@Column(name = "NOM")
	public String getNom(){
		return nom;
	}
	
	@Column(name = "TYPE")
	public String getType(){
		return type;
	}

	@ManyToMany(mappedBy = "interets")
	Set<Geek> geeks;
}
