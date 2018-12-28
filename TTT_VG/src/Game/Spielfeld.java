package Game;

public class Spielfeld {
	public static char[][] Zellen;
	
	public void Tabelleerstellen(String Spiel) {
		if (Spiel.equals("ttt")) {
			char[][] Zellen= new char[3][3];
		} else {
			char[][] Zellen= new char[7][6];		
		}
	}
	public void Anzeigen(int Spalten,int Zeilen) {
			
		
		if (Zeilen==3) {
			//Spielfeld zeichnen ttt
			for (int i = 0; i<Zeilen; i++) {
				for (int j = 0; j<Spalten; j++) {
					System.out.print(" "+Zellen[j][i]+" ");
					if (j<2) {System.out.print("|");}
				}
			System.out.println();	
			if (i<2) {System.out.println("-----------");}
			}
	} else {
		//Spielfeld zeichnen vg
			for (int i = Zeilen-1; i>-1; i--) {
				for (int j = 0; j<Spalten; j++) {
					System.out.print("|");
					if (Zellen[j][i]=='X') {
						System.out.print(" X ");
					} else {
					if (Zellen[j][i]=='O') {
						System.out.print(" O ");
					} else {
					System.out.print(" "+Zellen[j][i]+" ");
					}
					}
				}
			System.out.print("|");
			System.out.println();
			}
	}
		}
	
	public void Tabelleleeren(int Spalten,int Zeilen) {
	for (int i = 0; i < Zeilen; i++) {
        for (int j = 0; j < Spalten; j++) {
            Zellen[i][j] = ' ';
        }
    }
	}
	}
