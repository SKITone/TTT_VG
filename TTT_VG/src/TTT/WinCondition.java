package TTT;

public class WinCondition {

	public boolean gewonnen(char[][] Zellen) {

		//3 Gleiche in einer Reihe/Spalte/Diagonale gibt false zurück
		//System.out.println("test");
		for (int i = 0; i < 3; i++)
		{
			if (Zellen[i][0] == Zellen[i][1] && Zellen[i][0] == Zellen[i][2] && Zellen[i][0]!=' ') {return false;};	
			if (Zellen[0][i] == Zellen[1][i] && Zellen[0][i] == Zellen[2][i] && Zellen[0][i]!=' ') {return false;};			   
		}
			if (Zellen[0][0] == Zellen[1][1] && Zellen[0][0] == Zellen[2][2] && Zellen[0][0]!=' ') {return false;};	
			if (Zellen[0][2] == Zellen[1][1] && Zellen[0][2] == Zellen[2][0] && Zellen[0][2]!=' ') {return false;};
	

	    return true;
	}

	}
