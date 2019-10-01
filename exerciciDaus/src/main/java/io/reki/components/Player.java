package io.reki.components;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	
	private static int id;
	@Id
	private int idPlayer;
	private String playerName;
	private LocalDate registerDate;

	public Player(String name) {
		// TODO comparar nom amb existents pq no repeteixi
		this.playerName = name;
		this.idPlayer = id;
		id++;
		this.registerDate = java.time.LocalDate.now();
	}
	
	public Player() {
		this.playerName = "ANONIMOUS";
		this.idPlayer = id;
		id++;
		this.registerDate = java.time.LocalDate.now();
	}

	public Player createPlayer(String name) {
		Player player= new Player(name);
		return player;
		
	}
	
	public int getId() {
		return this.idPlayer;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public LocalDate getRegisterDate() {
		return this.registerDate;
	}
	public void setName(String next) {
		this.playerName = next;
		
	}

	

}