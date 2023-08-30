package dao;

import java.util.List;

import dao.entities.Voiture;

public interface IGestionVoiture {

	public void ajouterVoiture(Voiture v);
	public void supprimerVoiture(int id);
	public void mettreAJourVoiture(Voiture v);
	public List<Voiture> getAllVoitures();
	public List<Voiture> getVoitureBMC(String motcle);
	public Voiture getVoiture(int id);
	public List<Voiture> getVoituresByPage(int page, int pageSize);
}
