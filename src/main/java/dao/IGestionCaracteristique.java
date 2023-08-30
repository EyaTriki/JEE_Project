package dao;

import java.util.List;

import dao.entities.Caracteristique;



public interface IGestionCaracteristique {
	public void ajouterCaracteristique(Caracteristique c);
	public List<Caracteristique> getAllCaracteristique();
	public Caracteristique getCaracteristique (int id);
	public void deleteCaracteristique(int id);
}
