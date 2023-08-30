package dao.entities;

import javax.persistence.JoinColumn;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Voiture {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	public int id;
	private String modele;
	private String carburant;
	private double prix;
	private String filename;
	@ManyToOne
	private Marque marque;
	@ManyToMany
	
	@JoinTable(
	    name = "voiture_caracteristique",
	    joinColumns = @JoinColumn(name = "voiture_id"),
	    inverseJoinColumns = @JoinColumn(name = "caracteristique_id")
	)
	private List<Caracteristique> caractéristiques;

	
	public Voiture(int id, String modele, String carburant, double prix, String filename, Marque marque,
			List<Caracteristique> caractéristiques) {
		super();
		this.id = id;
		this.modele = modele;
		this.carburant = carburant;
		this.prix = prix;
		this.filename = filename;
		this.marque = marque;
		this.caractéristiques = caractéristiques;
	}
	
	public Voiture(int id, String modele, String carburant, double prix, Marque marque,
			List<Caracteristique> caractéristiques) {
		super();
		this.id = id;
		this.modele = modele;
		this.carburant = carburant;
		this.prix = prix;
		this.marque = marque;
		this.caractéristiques = caractéristiques;
	}
	public List<Caracteristique> getCaractéristiques() {
		return caractéristiques;
	}
	public void setCaractéristiques(List<Caracteristique> caractéristiques) {
		this.caractéristiques = caractéristiques;
	}
	public Voiture(int id, String modele, String carburant, double prix, Marque marque) {
		super();
		this.id = id;
		this.modele = modele;
		this.carburant = carburant;
		this.prix = prix;
		this.marque = marque;
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Voiture(int id, String modele, String carburant, double prix) {
		super();
		this.id = id;
		this.modele = modele;
		this.carburant = carburant;
		this.prix = prix;
	}
	public Voiture( String modele, String carburant, double prix) {
		super();
		this.modele = modele;
		this.carburant = carburant;
		this.prix = prix;
	}
	public Voiture() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getCarburant() {
		return carburant;
	}
	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", modele=" + modele + ", carburant=" + carburant + ", prix=" + prix + "]";
	}
	
	
}
