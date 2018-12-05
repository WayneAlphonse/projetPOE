package fr.dawan.DAO;

import fr.dawan.beans.Joueur;

public interface InterfaceJoueurDao<T> extends InterfaceDao<T>{
	
	Joueur findByEmail(String email);
	Joueur findByPseudo(String pseudo);
//	Boolean checkEmail(String email);
	

}
