package entity;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "GEEK")
public class Geek {
	int id;
	String nom, prenom, mail;
	char sexe;
	String avatar;
	
	@Id
	@Column(name = "ID_GEEK")
	@GeneratedValue
	public int getId(){
		return id;
	}
	
	@Column(name = "NOM")
	public String getNom(){
		return nom;
	};
	
	@Column(name = "PRENOM")
	public String getPrenom(){
		return prenom;
	}
	
	@Column(name = "MAIL")
	public String getMail(){
		return mail;
	}
	
	@Column(name = "SEXE")
	public char getSexe(){
		return sexe;
	}
	
	@Column(name = "AVATAR")
	public String getAvatar(){
		return avatar;
	}
	
	@ManyToMany
	@JoinTable(name = "INTERET_GEEK",
				joinColumns = @JoinColumn(name = "ID_GEEK"),
				inverseJoinColumns = @JoinColumn(name = "ID_INT"))
	Set<Interet> interets;

}
