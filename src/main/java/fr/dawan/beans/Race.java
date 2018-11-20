package fr.dawan.beans;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Race {
	private String nomRace;
	private String nomImage;
	@Enumerated(EnumType.STRING)
	private RaceAnimal raceDeRace;
	@Enumerated(EnumType.STRING)
	private TypeDePoil typeDePoil;
	
	public Race() {

	}
	public Race(String nomRace, String nomImage, RaceAnimal raceDeRace, TypeDePoil typeDePoil) {
		super();
		this.nomRace = nomRace;
		this.nomImage = nomImage;
		this.raceDeRace = raceDeRace;
		this.typeDePoil = typeDePoil;
	}
	public String getNomRace() {
		return nomRace;
	}
	public void setNomRace(String nomRace) {
		this.nomRace = nomRace;
	}
	public String getNomImage() {
		return nomImage;
	}
	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}
	public RaceAnimal getRace() {
		return raceDeRace;
	}
	public void setRace(RaceAnimal raceDeRace) {
		this.raceDeRace = raceDeRace;
	}
	public TypeDePoil getTypeDePoil() {
		return typeDePoil;
	}
	public void setTypeDePoil(TypeDePoil typeDePoil) {
		this.typeDePoil = typeDePoil;
	}
	
	

}
