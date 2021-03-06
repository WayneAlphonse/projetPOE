package fr.dawan.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.beans.Jeux;


@Transactional
public class JeuxDao implements InterfaceDao<Jeux>{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Jeux createOrUpdate(Jeux item) {
		Session session = sessionFactory.getCurrentSession();
		if(item.getId()==null) {
		session.persist(item);
		}else {
			session.merge(item);
		}
		return item;
	}

	

	@Override
	public List<Jeux> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Jeux> query = session.createQuery("SELECT entity FROM Jeux entity", Jeux.class);
		return query.getResultList();
	}



	@Override
	public Jeux findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}



}
