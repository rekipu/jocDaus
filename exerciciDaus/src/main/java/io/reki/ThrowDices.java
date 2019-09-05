package io.reki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ThrowDices {

	@Id
	@Column
	private static int id;
	@Column
	private int playerId;
	@Column
	private int dice1;
	@Column
	private int dice2;

	public static int tira() {
		int x = (int) (Math.random() * ((6 - 1) + 1)) + 1;
		return x;
	}

	public ThrowDices(int playerId) {
		this.playerId = playerId;
		this.id = id;
		id++;
		dice1 = tira();
		dice2 = tira();

		System.out.println("dau1: " + dice1 + " , dau2: " + dice2);
		System.out.println("Total: " + (dice1 + dice2));
		if (dice1 + dice2 == 7) {
			System.out.println("Player wins!! Congratulations!!");
		} else {
			System.out.println("Machine wins! we will rule the world, loser!");
		}

	}

}
