package fr.dawan.beans;

import javax.persistence.Entity;

@Entity

public class Jeux extends DbObject {

	private int tauxBonheur = 0;
	private String typeJeux;

	public Jeux() {

	}

	public String getTypeJeux() {
		return typeJeux;
	}

	public void setTypeJeux(String typeJeux) {
		this.typeJeux = typeJeux;
	}

	public int getTauxBonheur() {
		return tauxBonheur;
	}

	public void setTauxBonheur(int tauxBonheur) {
		this.tauxBonheur = tauxBonheur;
	}

}
