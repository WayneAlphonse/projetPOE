package fr.dawan.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Chat extends Animal {
	@Embedded
	private Race raceChat;



	public Chat() {

	}


	public Race getRace() {
		return raceChat;
	}

	public void setRace(Race race) {
		this.raceChat = race;
	}



}
