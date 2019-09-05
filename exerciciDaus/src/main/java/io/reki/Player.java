package io.reki;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Player {
	//@Id
	private static int id = 1;
	private String playerName;
	private LocalDate registerDate;

	public Player(String name) {
		// TODO comparar nom amb existents pq no repeteixi
		this.playerName = name;
		this.id = id;
		id++;
		this.registerDate = java.time.LocalDate.now();
	}
	public Player() {
		this.playerName = "ANONIMOUS";
		this.id = id;
		id++;
		this.registerDate = java.time.LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	

}