package fr.dawan.DAO;

import java.util.List;

public interface InterfaceDao<T>{
	
	T createOrUpdate( T item);
	
	T findById(int id);

	List<T> findAll();

	void delete(int id);
	
	

}
