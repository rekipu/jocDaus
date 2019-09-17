package io.reki;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER")
public class Player {
	
	private static int id = 1;
	@Id
	@Column(name="PLAYER_ID")
	private int idPlayer;
	@Column(name="PLAYER_NAME")
	private String playerName;
	@Column(name="REG_DATE")
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