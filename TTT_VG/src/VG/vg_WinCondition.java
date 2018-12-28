package VG;


public class vg_WinCondition {
	
	vg_Spielfeld Feld= new vg_Spielfeld();

	public boolean gewonnen(char[][] Zellen) {

		int viergewinnt=0;
		
		for (int i=0; i<7 ; i++) {
		viergewinnt=0;
		for (int j=0; j<5; j++) {
			if ((Zellen[i][j]==Zellen[i][j+1]) && ((Zellen[i][j]=='X') ||(Zellen[i][j]=='O'))) {	//Wenn in einer Zeile die benachbarten Zellen gleich sind:
				viergewinnt++;																							//viergewinnt um 1 erhöht
				if (viergewinnt==3) { 
					//System.out.println(i+" "+j);
					//System.out.println("vertikal");
					return false; }
			} else {
				viergewinnt=0;
			}
		}}
		

		
		for (int j=0; j<6; j++) {
		viergewinnt=0;		
		for (int i=0; i<6; i++) {
			if ((Zellen[i][j]==Zellen[i+1][j]) && ((Zellen[i][j]=='X') ||(Zellen[i][j]=='O'))) {		//Wenn in einer Spalte die benachbarten Zellen gleich sind:
				viergewinnt++;																							//viergewinnt um 1 erhöht
				if (viergewinnt==3) {
					//System.out.println(i+" "+j);
					//System.out.println("horizontal");
					//Feld.Anzeigen(Zellen);
				return false; }
			} else {
				viergewinnt=0;
			}
		}}
		
		
		for (int i=1; i<6; i=i+2) {
			for (int j=2; j<4; j++) {
		
		int diag_Spalte=i;
		int diag_Zeile=j;
		
		viergewinnt=0;
		
		while (diag_Spalte>0 && diag_Zeile>0) {
			diag_Spalte--;
			diag_Zeile--;
		}
		
		while (diag_Spalte<6 && diag_Zeile<5) {																		//Schleife zur Überprüfung, ob WinCondition in 
																														//der Diagonale erfüllt ist
			if ((Zellen[diag_Spalte][diag_Zeile]==Zellen[diag_Spalte+1][diag_Zeile+1]) && ((Zellen[diag_Spalte][diag_Zeile]=='X') || (Zellen[diag_Spalte][diag_Zeile]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) {
					//System.out.println(diag_Spalte+" "+diag_Zeile);
					//System.out.println("steigend");
					//Feld.Anzeigen(Zellen);
					return false; }
			} else {
				viergewinnt=0;
			}
			diag_Spalte++;
			diag_Zeile++;
		}
		
		
		viergewinnt=0;
		
		diag_Spalte=i;
		diag_Zeile=j;
		
		while (diag_Spalte>0 && diag_Zeile<5) {
			diag_Spalte--;
			diag_Zeile++;
		}
		
		while (diag_Spalte<6 && diag_Zeile>0) {																		//Schleife zur Überprüfung, ob WinCondition in
																														//der Diagonale erfüllt ist
			if ((Zellen[diag_Spalte][diag_Zeile]==Zellen[diag_Spalte+1][diag_Zeile-1]) && ((Zellen[diag_Spalte][diag_Zeile]=='X') || (Zellen[diag_Spalte][diag_Zeile]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) { 
					//System.out.println(diag_Spalte+" "+diag_Zeile);
					//System.out.println("fallend");
					//Feld.Anzeigen(Zellen);
					return false; }
			} else {
				viergewinnt=0;
			}
			diag_Spalte++;
			diag_Zeile--;
		}
	}}
		return true;
	}
	

	public boolean gewonnen(char[][] Zellen, int Spalte, int Zeile) {

		int viergewinnt=0;
		
		for (int i=0; i<5; i++) {
			if ((Zellen[Spalte][i]==Zellen[Spalte][i+1]) && ((Zellen[Spalte][i]=='X') ||(Zellen[Spalte][i]=='O'))) {	//Wenn in einer Zeile die benachbarten Zellen gleich sind:
				viergewinnt++;																							//viergewinnt um 1 erhöht
				if (viergewinnt==3) { 
					//Feld.Anzeigen(Zellen);
					return false; }
			} else {
				viergewinnt=0;
			}
		}
		
		viergewinnt=0;
		
		for (int i=0; i<6; i++) {
			if ((Zellen[i][Zeile]==Zellen[i+1][Zeile]) && ((Zellen[i][Zeile]=='X') ||(Zellen[i][Zeile]=='O'))) {		//Wenn in einer Spalte die benachbarten Zellen gleich sind:
				viergewinnt++;																							//viergewinnt um 1 erhöht
				if (viergewinnt==3) {
					//Feld.Anzeigen(Zellen);
				return false; }
			} else {
				viergewinnt=0;
			}
		}
		
		viergewinnt=0;
		
		int diag_Spalte=Spalte;
		int diag_Zeile=Zeile;
		
		while (diag_Spalte!=0 && diag_Zeile!=0) {
			diag_Spalte--;
			diag_Zeile--;
		}
		
		while (diag_Spalte!=6 && diag_Zeile!=5) {																		//Schleife zur Überprüfung, ob WinCondition in 
																														//der Diagonale erfüllt ist
			if ((Zellen[diag_Spalte][diag_Zeile]==Zellen[diag_Spalte+1][diag_Zeile+1]) && ((Zellen[diag_Spalte][diag_Zeile]=='X') || (Zellen[diag_Spalte][diag_Zeile]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) { 
					//Feld.Anzeigen(Zellen);
					return false; }
			} else {
				viergewinnt=0;
			}
			diag_Spalte++;
			diag_Zeile++;
		}
		
		
		viergewinnt=0;
		
		diag_Spalte=Spalte;
		diag_Zeile=Zeile;
		
		while (diag_Spalte!=0 && diag_Zeile!=5) {
			diag_Spalte--;
			diag_Zeile++;
		}
		
		while (diag_Spalte!=6 && diag_Zeile!=0) {																		//Schleife zur Überprüfung, ob WinCondition in
																														//der Diagonale erfüllt ist
			if ((Zellen[diag_Spalte][diag_Zeile]==Zellen[diag_Spalte+1][diag_Zeile-1]) && ((Zellen[diag_Spalte][diag_Zeile]=='X') || (Zellen[diag_Spalte][diag_Zeile]=='O'))) {
				viergewinnt++;
				if (viergewinnt==3) { 
					//Feld.Anzeigen(Zellen);
					return false; }
			} else {
				viergewinnt=0;
			}
			diag_Spalte++;
			diag_Zeile--;
		}
	

	    return true;
	}
	}