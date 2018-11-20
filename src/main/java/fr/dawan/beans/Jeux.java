package fr.dawan.beans;

import javax.persistence.Entity;

@Entity

public class Jeux extends DbObject {
	
	private int tauxBonheur;
	private int dureeJeux;
	private String typeJeux;
	
	
	
	public String getTypeJeux() {
		return typeJeux;
	}
	public void setTypeJeux(String typeJeux) {
		this.typeJeux = typeJeux;
	}
	public Jeux() {
	
	}
	public int getTauxBonheur() {
		return tauxBonheur;
	}
	public void setTauxBonheur(int tauxBonheur) {
		this.tauxBonheur = tauxBonheur;
	}
	public int getDureeJeux() {
		return dureeJeux;
	}
	public void setDureeJeux(int dureeJeux) {
		this.dureeJeux = dureeJeux;
	}
	
	

}
