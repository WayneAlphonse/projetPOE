package fr.dawan.DAO;

import fr.dawan.beans.Dodo;

public interface InterfaceDodoDao <T> extends InterfaceDao<T> {
	
	Dodo findByLieu(String lieu);
	

}
