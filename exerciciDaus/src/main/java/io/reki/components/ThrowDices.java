package io.reki.components;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ThrowDices {

	@Transient
	private static int id=1;
	@Id 
	private int idThrow;
	private int playerId;
	private int dice1;
	private int dice2;
	boolean won;

	public int getIdThrow() {
		return idThrow;
	}


	public int getPlayerId() {
		return playerId;
	}


	public int getDice1() {
		return dice1;
	}


	public int getDice2() {
		return dice2;
	}


	public boolean isWon() {
		return won;
	}


	public static int tira() {
		int x = (int) (Math.random() * ((6 - 1) + 1)) + 1;
		return x;
	}
	
	public ThrowDices() {
		super();
	}

	public ThrowDices(int playerId) {
		this.playerId = playerId;
		this.dice1 = tira();
		this.dice2 = tira();	
		this.idThrow=id;
		id++;
		this.won= tiraDaus();
		

	}
	
	@Override
	public String toString() {
		return "ThrowDices [idThrow=" + idThrow + ", playerId=" + playerId + ", dice1=" + dice1 + ", dice2=" + dice2
				+ ", won=" + won + "]";
	}


	public boolean tiraDaus() {
		System.out.println("dau1: " + dice1 + " , dau2: " + dice2);
		System.out.println("Total: " + (dice1 + dice2));
		if (dice1 + dice2 == 7) {
			System.out.println("Player wins!! Congratulations!!");
			return true;
		} else {
			System.out.println("Machine wins! we will rule the world, loser!");
			return false;
		}
	}

}
