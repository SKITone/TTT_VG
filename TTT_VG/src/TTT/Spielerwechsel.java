package TTT;

public class Spielerwechsel {
public static char Player='X';

public void wechseln() {
    if (Player == 'X') { 
    	Player = 'O'; 
    	} else { 
    	Player = 'X';}	
}

public char getSpieler() {
	return Player;
	}

public void setSpieler() {
	Player='X';
}
public void setSpieler(char Spieler) {
	Player=Spieler;
}
}