package fr.dawan.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.beans.Nourriture;

@Transactional
public class NourritureDao implements InterfaceNourritureDao<Nourriture> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Nourriture createOrUpdate(Nourriture item) {
		Session session = sessionFactory.getCurrentSession();
		if (item.getId() == null) {
			session.persist(item);
		} else {
			session.merge(item);
		}
		return item;
	}

	@Override
	public List<Nourriture> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Nourriture> query = session.createQuery("SELECT entity FROM Nourriture entity", Nourriture.class);
		return query.getResultList();
	}

	@Override
	public Nourriture findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Nourriture findByTypeNourriture(String typeNourriture) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Nourriture> query = session.createQuery("SELECT entity FROM Nourriture entity WHERE entity.typeNourriture='" + typeNourriture + "'", Nourriture.class);
		return query.getSingleResult();
	
	}

	
}
