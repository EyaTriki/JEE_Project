package dao;

import java.util.List;

import dao.entities.Marque;

public interface IGestionMarque {

	public void ajouterMarque(Marque m);
	public List<Marque> getAllMarques();
	public Marque getMarque (int id);
	public void deleteMarque(int id);
}
