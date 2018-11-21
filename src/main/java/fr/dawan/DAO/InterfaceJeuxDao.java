package fr.dawan.DAO;

import fr.dawan.beans.Jeux;

public interface InterfaceJeuxDao<T> extends InterfaceDao<T> {
	
	Jeux findByTypeJeux(String typeJeux);

}
