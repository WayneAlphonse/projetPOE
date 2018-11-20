package fr.dawan.beans;



import javax.persistence.Embedded;
import javax.persistence.Entity;


@Entity
public class Chien extends Animal {
	@Embedded
	private Race raceChien;


	public Chien() {

	}

	public Race getRaceChien() {
		return raceChien;
	}

	public void setRaceChien(Race raceChien) {
		this.raceChien = raceChien;
	}



}
