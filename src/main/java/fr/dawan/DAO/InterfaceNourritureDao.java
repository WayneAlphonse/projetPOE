package fr.dawan.DAO;

import fr.dawan.beans.Nourriture;

public interface InterfaceNourritureDao<T> extends InterfaceDao<T> {
	
	Nourriture findByTypeNourriture(String typeNourriture);

}
