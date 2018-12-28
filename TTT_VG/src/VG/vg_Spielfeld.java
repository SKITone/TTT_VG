package VG;

public class vg_Spielfeld {
public static char[][] Zellen = new char[7][6];

public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_YELLOW = "\u001B[33m";

public void Anzeigen() {
	
		int Spalten=7;	
		int Zeilen=6;

		//Spielfeld zeichnen
		for (int i = Zeilen-1; i>-1; i--) {					//doppelte Schleife zur Erstellung des Spielfeldes
			for (int j = 0; j<Spalten; j++) {
				System.out.print("|");						//Strich zur Begrenzung schreiben
				if (Zellen[j][i]=='X') {
					System.out.print(" X ");				//wenn Spieler X die Position besetzt hat, dann X schreiben
				} else {	
				if (Zellen[j][i]=='O') {					//wenn Spieler O die Position besetzt hat, dann O schreiben
					//System.out.print(ANSI_YELLOW+"O"+ANSI_RESET);
					System.out.print(" O ");
				} else {
				System.out.print(" "+Zellen[j][i]+" ");		//wenn kein Spieler die Position besetzt hat, wird ein Leerzeichen geschrieben
				}
				}
			}
		System.out.print("|");
		System.out.println();
		}
		for (int i=0; i<7; i++) {
			System.out.print("  "+(i+1)+" ");
		}
		System.out.println();
	}

public void Anzeigen(char[][] Zellen) {
	int Spalten=7;	
	int Zeilen=6;

	//Spielfeld zeichnen
	for (int i = Zeilen-1; i>-1; i--) {					//doppelte Schleife zur Erstellung des Spielfeldes
		for (int j = 0; j<Spalten; j++) {
			System.out.print("|");						//Strich zur Begrenzung schreiben
			if (Zellen[j][i]=='X') {
				System.out.print(" X ");				//wenn Spieler X die Position besetzt hat, dann X schreiben
			} else {	
			if (Zellen[j][i]=='O') {					//wenn Spieler O die Position besetzt hat, dann O schreiben
				//System.out.print(ANSI_YELLOW+"O"+ANSI_RESET);
				System.out.print(" O ");
			} else {
			System.out.print(" "+Zellen[j][i]+" ");		//wenn kein Spieler die Position besetzt hat, wird ein Leerzeichen geschrieben
			}
			}
		}
	System.out.print("|");
	System.out.println();
	}
	System.out.println();
}

public void setSpielfeld(char[][] Feld) {
	for (int i = 0; i<7; i++) {						//doppelter Schleifendurchlauf (jeweils 3x)
		for (int j = 0; j<6; j++) {
			//System.out.println(Feld[i][j]+" i: "+i+" j: "+j);
			Zellen[i][j]=Feld[i][j];	
		}
	}
}
}
