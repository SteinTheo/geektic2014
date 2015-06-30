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
	
	@Id
	@Column(name = "ID_GEEK")
	@GeneratedValue
	public void setId(int id2){
		id = id2;
	}
	
	@Column(name = "NOM")
	public String getNom(){
		return nom;
	};
	
	@Column(name = "NOM")
	public void setNom(String nom){
		this.nom=nom;
	};
	
	@Column(name = "PRENOM")
	public String getPrenom(){
		return prenom;
	}
	
	@Column(name = "PRENOM")
	public void setPrenom(String prenom){
		this.prenom=prenom;
	};
	
	@Column(name = "MAIL")
	public String getMail(){
		return mail;
	}
	
	@Column(name = "MAIL")
	public void setMail(String mail){
		this.mail=mail;
	};
	
	@Column(name = "SEXE")
	public char getSexe(){
		return sexe;
	}
	
	@Column(name = "SEXE")
	public void setSexe(char sexe){
		this.sexe = sexe;
	}
	
	@Column(name = "AVATAR")
	public String getAvatar(){
		return avatar;
	}
	
	@Column(name = "AVATAR")
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
	
	@ManyToMany
	@JoinTable(name = "INTERET_GEEK",
				joinColumns = @JoinColumn(name = "ID_GEEK"),
				inverseJoinColumns = @JoinColumn(name = "ID_INT"))
	Set<Interet> interets;

}
