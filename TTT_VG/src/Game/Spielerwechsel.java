package Game;

public class Spielerwechsel {
	public static char Player='X';

	public void wechseln() {
	    if (Player == 'X') { 
	    	Player = 'O'; 
	    	//System.out.println(Player);
	    	} else { 
	    	Player = 'X';}	
	}

	public char getSpieler() {
		return Player;
		}

	public void setSpieler() {
		Player='X';
	}
}
