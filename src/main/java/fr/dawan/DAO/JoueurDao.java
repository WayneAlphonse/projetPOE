package fr.dawan.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.beans.Animal;
import fr.dawan.beans.Joueur;

@Transactional
public class JoueurDao implements InterfaceJoueurDao<Joueur> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Joueur createOrUpdate(Joueur item) {

		Session session = sessionFactory.getCurrentSession();
		if (item.getId() == null) {
			session.persist(item);
		} else {
			session.merge(item);
		}
		return item;

	}

	public Joueur findByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Joueur> query = session
				.createQuery("SELECT entity FROM Joueur entity WHERE entity.email='" + email + "'", Joueur.class);
		List<Joueur> listJoueur = query.getResultList();
		if(listJoueur.size()==1) {
			return listJoueur.get(0);
		}
		return null;

	}

	@Override
	public Joueur findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public List<Joueur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Joueur findByPseudo(String pseudo) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Joueur> query = session
				.createQuery("SELECT entity FROM Joueur entity WHERE entity.pseudo='" + pseudo + "'", Joueur.class);
		List<Joueur> listJoueur = query.getResultList();
		if(listJoueur.size()==1) {
			return listJoueur.get(0);
		}
		return null;
	}

//	@Override
//	public Boolean checkEmail(String email) {
//		Session session = sessionFactory.getCurrentSession();
//		TypedQuery<Joueur> query = session
//				.createQuery("SELECT entity FROM Joueur entity WHERE entity.email='" + email + "'", Joueur.class);
//		return query.getSingleResult() == null;
//	}

}
