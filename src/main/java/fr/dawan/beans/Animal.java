package fr.dawan.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal extends DbObject {

	private String nom;
	private int gourmand = 100;
	private int sportif = 100;
	private int marmotte = 100;
	private String couleur;
	private String nomImage;
	@Enumerated(EnumType.STRING)
	private TypeAnimal typeAnimal;

	public Animal() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getGourmand() {
		return gourmand;
	}

	public void setGourmand(int gourmand) {
		this.gourmand = gourmand;
	}

	public int getSportif() {
		return sportif;
	}

	public void setSportif(int sportif) {
		this.sportif = sportif;
	}

	public int getMarmotte() {
		return marmotte;
	}

	public void setMarmotte(int marmotte) {
		this.marmotte = marmotte;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public TypeAnimal getTypeAnimal() {
		return typeAnimal;
	}

	public void setTypeAnimal(TypeAnimal typeAnimal) {
		this.typeAnimal = typeAnimal;
	}

}
