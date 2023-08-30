package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.entities.Marque;
import dao.entities.Voiture;

public class GestionMarqueImp implements IGestionMarque{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test"); //la relation entre l'entite et la ficher persistence
    EntityManager em=emf.createEntityManager();//on trouve tout les crud
	@Override
	public void ajouterMarque(Marque m) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(m);
		et.commit();
		
	}

	@Override
	public List<Marque> getAllMarques() {
		Query q =em.createQuery("select m from Marque m");
		return q.getResultList();
	}

	@Override
	public Marque getMarque(int id) {
		return em.find(Marque.class, id);
	}

	@Override
	public void deleteMarque(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(getMarque(id));
		et.commit();
		
	}

}
