package dao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Caracteristique {
	public Caracteristique(int id, String boite, String puissance, String etat, List<Voiture> voitures) {
		super();
		this.id = id;
		this.boite = boite;
		this.puissance = puissance;
		this.etat = etat;
		this.voitures = voitures;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoite() {
		return boite;
	}
	public void setBoite(String boite) {
		this.boite = boite;
	}
	public String getPuissance() {
		return puissance;
	}
	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public List<Voiture> getVoitures() {
		return voitures;
	}
	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	public int id;
	private String boite;
	private String puissance;
	private String etat;
	@ManyToMany(mappedBy = "caractéristiques")
	private List<Voiture> voitures;
}
