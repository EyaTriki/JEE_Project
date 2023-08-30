package dao;

import java.util.List;
import javax.persistence.TypedQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import dao.entities.Voiture;



public class GestionVoitureImpJpa implements IGestionVoiture {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test"); 
    EntityManager em=emf.createEntityManager();
	@Override
	public void ajouterVoiture(Voiture v) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(v);
		et.commit();
	}
	@Override
	public void supprimerVoiture(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(getVoiture(id));
		et.commit();
		}
	@Override
	public void mettreAJourVoiture(Voiture v) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(v);
		et.commit();
	}
	@Override
	public List<Voiture> getAllVoitures() {
		Query q =em.createQuery("select v from Voiture v");
		return q.getResultList();
	}
	@Override
	public List<Voiture> getVoitureBMC(String motcle) {
	    TypedQuery<Voiture> query = em.createQuery("SELECT v FROM Voiture v WHERE v.modele LIKE :motcle", Voiture.class);
	    query.setParameter("motcle", "%" + motcle + "%");
	    return query.getResultList();
	}
	@Override
	public Voiture getVoiture(int id) {
		// TODO Auto-generated method stub
		return em.find(Voiture.class, id);
	}
	


	@Override
	public List<Voiture> getVoituresByPage(int page, int pageSize) {
		int startIndex = (page - 1) * pageSize; // Calcul de l'index de départ pour la page spécifiée
	    
	    TypedQuery<Voiture> query = em.createQuery("SELECT v FROM Voiture v", Voiture.class);
	    query.setFirstResult(startIndex);
	    query.setMaxResults(pageSize);
	    List<Voiture> liste = query.getResultList();
	
	    return liste;
	    
	}

    
}
