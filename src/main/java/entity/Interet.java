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
	
	@Id
	@Column(name = "ID_INT")
	@GeneratedValue
	public void setId(int id){
		this.id=id;
	}
	
	@Column(name = "NOM")
	public String getNom(){
		return nom;
	}
	
	@Column(name = "NOM")
	public void setNom(String nom){
		this.nom=nom;
	}
	
	@Column(name = "TYPE")
	public String getType(){
		return type;
	}
	
	@Column(name = "Type")
	public void setType(String type){
		this.type=type;
	}

	@ManyToMany(mappedBy = "interets")
	Set<Geek> geeks;
}
