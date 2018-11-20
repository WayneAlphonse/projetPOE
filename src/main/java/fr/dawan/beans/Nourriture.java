package fr.dawan.beans;

import javax.persistence.Entity;

@Entity
public class Nourriture extends DbObject{
	private int tauxSatiete;
	private String typeNourriture;
	private int quantite;
	
	
	
	public Nourriture() {
	
	}
	
	public int getTauxSatiete() {
		return tauxSatiete;
	}
	public void setTauxSatiete(int tauxSatiete) {
		this.tauxSatiete = tauxSatiete;
	}
	public String getTypeNourriture() {
		return typeNourriture;
	}
	public void setTypeNourriture(String typeNourriture) {
		this.typeNourriture = typeNourriture;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
