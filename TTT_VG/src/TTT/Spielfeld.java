package TTT;

public class Spielfeld {
public static char[][] Zellen = new char[3][3];

public void Anzeigen() {
		
		int Spalten=3;	
		int Zeilen=3;

		//Spielfeld zeichnen
		for (int i = 0; i<Zeilen; i++) {						//doppelter Schleifendurchlauf (jeweils 3x)
			for (int j = 0; j<Spalten; j++) {					
				System.out.print(" "+Zellen[j][i]+" ");			//Zellen pro Schleifendurchlauf "zeichnen"
																
				if (j<2) {System.out.print("|");}				//Begrenzung "zeichnen"
			}
		System.out.println();									
		if (i<2) {System.out.println("-----------");}			//Begrenung "zeichnen"
		}
	}

public void Anzeigen(char[][] Zellen) {
	int Spalten=3;	
	int Zeilen=3;

	//Spielfeld zeichnen
	for (int i = 0; i<Zeilen; i++) {						//doppelter Schleifendurchlauf (jeweils 3x)
		for (int j = 0; j<Spalten; j++) {					
			System.out.print(" "+Zellen[j][i]+" ");			//Zellen pro Schleifendurchlauf "zeichnen"
															
			if (j<2) {System.out.print("|");}				//Begrenzung "zeichnen"
		}
	System.out.println();									
	if (i<2) {System.out.println("-----------");}			//Begrenung "zeichnen"
	}
}

public void setSpielfeld(char[][] Feld) {
	for (int i = 0; i<3; i++) {						//doppelter Schleifendurchlauf (jeweils 3x)
		for (int j = 0; j<3; j++) {
			//System.out.println(Feld[i][j]);
			Zellen[i][j]=Feld[i][j];	
		}
	}
}
public void ladeSpielfeld() {
	Zellen[0][0]='O';
	Zellen[0][1]='O';
	Zellen[0][2]=' ';
	Zellen[1][0]='X';
	Zellen[1][1]=' ';
	Zellen[1][2]='O';
	Zellen[2][0]=' ';
	Zellen[2][1]=' ';
	Zellen[2][2]=' ';
}

public char[][] ladeSpielfeldleer() {
	char[][] Zellen=new char[3][3];
	Zellen[0][0]=' ';
	Zellen[0][1]=' ';
	Zellen[0][2]=' ';
	Zellen[1][0]=' ';
	Zellen[1][1]=' ';
	Zellen[1][2]=' ';
	Zellen[2][0]=' ';
	Zellen[2][1]=' ';
	Zellen[2][2]=' ';
	return Zellen;
}
}
