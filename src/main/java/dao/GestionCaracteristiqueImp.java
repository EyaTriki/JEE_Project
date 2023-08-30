package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.entities.Caracteristique;
import dao.entities.Voiture;

public class GestionCaracteristiqueImp implements IGestionCaracteristique{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test"); 
    EntityManager em=emf.createEntityManager();
	@Override
	public void ajouterCaracteristique(Caracteristique c) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
	}

	@Override
	public List<Caracteristique> getAllCaracteristique() {
		Query q =em.createQuery("select c from Caracteristique c");
		return q.getResultList();
	}

	@Override
	public Caracteristique getCaracteristique(int id) {
		// TODO Auto-generated method stub
		return em.find(Caracteristique.class, id);
	}

	@Override
	public void deleteCaracteristique(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(getCaracteristique(id));
		et.commit();
		
	}

}
