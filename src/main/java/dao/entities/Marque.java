package dao.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Marque {
@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String nom;
private String pays_origine;
private int annee_fondation;
@OneToMany(mappedBy ="marque", cascade=CascadeType.ALL)
private List<Voiture>liste;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPays_origine() {
	return pays_origine;
}
public void setPays_origine(String pays_origine) {
	this.pays_origine = pays_origine;
}
public int getAnnee_fondation() {
	return annee_fondation;
}
public void setAnnee_fondation(int annee_fondation) {
	this.annee_fondation = annee_fondation;
}
public List<Voiture> getListe() {
	return liste;
}
public void setListe(List<Voiture> liste) {
	this.liste = liste;
}
public Marque(int id, String nom, String pays_origine, int annee_fondation, List<Voiture> liste) {
	super();
	this.id = id;
	this.nom = nom;
	this.pays_origine = pays_origine;
	this.annee_fondation = annee_fondation;
	this.liste = liste;
}
public Marque( String nom, String pays_origine, int annee_fondation, List<Voiture> liste) {
	
	this.nom = nom;
	this.pays_origine = pays_origine;
	this.annee_fondation = annee_fondation;
	this.liste = liste;
}
public Marque() {
	
}

}
