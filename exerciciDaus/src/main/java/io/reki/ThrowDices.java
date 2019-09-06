package io.reki;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ThrowDices {

	private static int id=1;
	@Id
	private int idThrow = 1;
	private int playerId;
	private int dice1;
	private int dice2;
	boolean won;

	public static int tira() {
		int x = (int) (Math.random() * ((6 - 1) + 1)) + 1;
		return x;
	}
	

	public ThrowDices(int playerId) {
		this.playerId = playerId;
		this.idThrow = id;
		id++;
		dice1 = tira();
		dice2 = tira();

		System.out.println("dau1: " + dice1 + " , dau2: " + dice2);
		System.out.println("Total: " + (dice1 + dice2));
		if (dice1 + dice2 == 7) {
			System.out.println("Player wins!! Congratulations!!");
			won=true;
		} else {
			System.out.println("Machine wins! we will rule the world, loser!");
			won=false;
		}
		
		

	}

}
