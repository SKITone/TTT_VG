package Game;

public class WinCondition {
	char[][] Zellen = Spielfeld.Zellen;

	
	public boolean gewonnen(String Spiel, int Spalte, int Zeile) {
		if (Spiel=="ttt") {return gewonnenttt();} else
		{return gewonnenvg(Spalte, Zeile);}
		
	}
	public boolean gewonnenttt() {

		//3 Gleiche in einer Reihe/Spalte/Diagonale gibt true zurück
		for (int i = 0; i < 3; i++)
		{
			if (Zellen[i][0] == Zellen[i][1] && Zellen[i][0] == Zellen[i][2] && Zellen[i][0]!=' ') {return false;};	
			if (Zellen[0][i] == Zellen[1][i] && Zellen[0][i] == Zellen[2][i] && Zellen[0][i]!=' ') {return false;};			   
		}
			if (Zellen[0][0] == Zellen[1][1] && Zellen[0][0] == Zellen[2][2] && Zellen[0][0]!=' ') {return false;};	
			if (Zellen[0][2] == Zellen[1][1] && Zellen[0][2] == Zellen[2][0] && Zellen[0][2]!=' ') {return false;};
	

	    return true;
	}
	
	public boolean gewonnenvg(int Spalte, int Zeile) {

		int viergewinnt=0;
		
		for (int i=0; i<5; i++) {
			if ((Zellen[Spalte][i]==Zellen[Spalte][i+1]) && ((Zellen[Spalte][i]=='X') ||(Zellen[Spalte][i]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) { //System.out.println("win Spalte"); 
					return false; }
			} else {
				viergewinnt=0;
			}
		}
		for (int i=0; i<6; i++) {
			if ((Zellen[i][Zeile]==Zellen[i+1][Zeile]) && ((Zellen[i][Zeile]=='X') ||(Zellen[i][Zeile]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) { //System.out.println("win Zeile");
				return false; }
			} else {
				viergewinnt=0;
			}
		}
		
		int diag_Spalte=Spalte;
		int diag_Zeile=Zeile;
		
		while (diag_Spalte!=0 && diag_Zeile!=0) {
			diag_Spalte--;
			diag_Zeile--;
		}
		
		while (diag_Spalte!=6 && diag_Zeile!=5) {
			if ((Zellen[diag_Spalte][diag_Zeile]==Zellen[diag_Spalte+1][diag_Zeile+1]) && ((Zellen[diag_Spalte][diag_Zeile]=='X') || (Zellen[diag_Spalte][diag_Zeile]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) { return false; }
			} else {
				viergewinnt=0;
			}
			diag_Spalte++;
			diag_Zeile++;
		}
		
		diag_Spalte=Spalte;
		diag_Zeile=Zeile;
		
		while (diag_Spalte!=0 && diag_Zeile!=5) {
			diag_Spalte--;
			diag_Zeile++;
		}
		
		while (diag_Spalte!=6 && diag_Zeile!=0) {
			if ((Zellen[diag_Spalte][diag_Zeile]==Zellen[diag_Spalte+1][diag_Zeile-1]) && ((Zellen[diag_Spalte][diag_Zeile]=='X') || (Zellen[diag_Spalte][diag_Zeile]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) { return false; }
			} else {
				viergewinnt=0;
			}
			diag_Spalte++;
			diag_Zeile--;
		}
	

	    return true;
	}

}
