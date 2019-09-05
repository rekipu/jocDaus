package io.reki;

public class ThrowDices {
	
	private int id;
	private int playerId;
	private int dice1;
	private int dice2;
	

public static int tira(){
    int x = (int)(Math.random()*((6-1)+1))+1;
    return x;
}
	
	public ThrowDices(int playerId) {
		this.playerId = playerId;
		dice1 = tira();
		dice2 = tira();
		
		System.out.println("dau1: " + dice1 + " , dau2: " + dice2);
		System.out.println("Total: "+ (dice1 + dice2));
		if(dice1+dice2 == 7) {
			System.out.println("Player wins!! Congratulations!!");
		}else {
			System.out.println("Machine wins! we will rule the world, loser!");
		}
		
	}
	
	
}
