package fr.dawan.beans;

import javax.persistence.Entity;

@Entity
public class Dodo extends DbObject{
	private int tauxSommeil;
	private int dureeSommeil;
	private String lieu;
	
	
	
	public Dodo() {
	
	}
	public int getTauxSommeil() {
		return tauxSommeil;
	}
	public void setTauxSommeil(int tauxSommeil) {
		this.tauxSommeil = tauxSommeil;
	}
	public int getDureeSommeil() {
		return dureeSommeil;
	}
	public void setDureeSommeil(int dureeSommeil) {
		this.dureeSommeil = dureeSommeil;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	

}
