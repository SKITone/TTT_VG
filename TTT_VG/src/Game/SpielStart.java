package Game;

import java.util.Scanner;

public class SpielStart {
	
	public void starteSpiel(String Spiel, String Modus) {
		Spielzug Zug= new Spielzug();
		Spielfeld Feld= new Spielfeld();
		WinCondition win= new WinCondition();
		Spielerwechsel wechsel= new Spielerwechsel();
		Scanner scanner= new Scanner(System.in);
		
		char[][] Zellen =Spielfeld.Zellen;
		
		int Zeilen=0, Spalten=0, maxZuganzahl=0;
		if (Spiel.equals("ttt")) {
			Zeilen=3;
			Spalten=3;
			maxZuganzahl=9;
		} else {
			Zeilen=6;
			Spalten=7;
			maxZuganzahl=42;
		}

		wechsel.setSpieler();
		//Leerzeichen in Zellen schreiben

		Feld.Anzeigen(Zeilen,Spalten);
		int Zuganzahl=1;
		boolean unentschieden=false;
		//Spielzug wird solange wiederholt bis einer gewonnen hat oder das Spiel unentschieden endet
		do {               
			if (Zuganzahl==1) {Feld.Tabelleleeren(Spalten, Zeilen);}
			Zug.Zug(Spiel,Modus);
			Zuganzahl++;
			if (Zuganzahl>maxZuganzahl) {
				unentschieden=true;
				break;
			}
		} while (win.gewonnen(Spiel, Spalten, Zeilen));
		
		//Ende
		System.out.println();
		wechsel.wechseln();
		//System.out.println(wechsel.getSpieler());
		if (unentschieden) {
			System.out.println("unentschieden");
		} else {
		System.out.println(wechsel.getSpieler()+" hat gewonnen!");
		}

		System.out.println();
		System.out.println("neues Spiel");
		String warten= scanner.next();
		
		scanner.close();
	}

}
