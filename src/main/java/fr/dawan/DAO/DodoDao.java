package fr.dawan.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.beans.Dodo;




@Transactional
public class DodoDao implements InterfaceDodoDao<Dodo>{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Dodo createOrUpdate(Dodo item) {
		Session session = sessionFactory.getCurrentSession();
		if(item.getId()==null) {
		session.persist(item);
		}else {
			session.merge(item);
		}
		return item;
	}

	@Override
	public List<Dodo> findAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Dodo> query = session.createQuery("SELECT entity FROM Dodo entity", Dodo.class);
		return query.getResultList();
	}
	
	
	@Override
	public Dodo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dodo findByLieu(String lieu) {
		Session session = sessionFactory.getCurrentSession();	
		TypedQuery<Dodo> query = session.createQuery("SELECT entity FROM Dodo entity WHERE entity.lieu='" + lieu + "'", Dodo.class);
		return query.getSingleResult();
	}

}
