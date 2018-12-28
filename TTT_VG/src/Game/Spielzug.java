package Game;

import java.util.Scanner;

public class Spielzug {
	Scanner scanner= new Scanner(System.in);
	freieZelle frei= new freieZelle();
	Eintragen update= new Eintragen();

	public void Zug(String Spiel,String Modus) {
		
		//Positionsabfrage
		boolean pruef=false;
		do {
			int Spalte=0;
			int Zeile=0;
			
			System.out.print("Bitte geben Sie die Spalte an: ");
			Spalte= scanner.nextInt();
			if (Spiel.equals("ttt")) {
			System.out.print("Bitte geben Sie die Zeile an: ");
			Zeile= scanner.nextInt();
			}
			pruef=false;
			
			//System.out.print(Zeile);
			//System.out.print(Spalte);
			
			if (Spiel.equals("ttt")) {
			if ((Spalte==1 || Spalte==2 || Spalte==3) && (Zeile==1 || Zeile==2 || Zeile==3)) {
				if (!frei.besetzt(Spiel, Spalte, Zeile)) {
					System.err.println("Diese Zelle ist besetzt");
					pruef=true;
				} else { 
					update.setzenttt(Spalte, Zeile); }; //X oder O wird in Zelle geschrieben
			} else {
				System.err.println("Falsche Eingabe.");
				pruef=true;
			}
			} else {
			
			if (Spalte>0 && Spalte<8) {
				if (frei.besetzt(Spiel, Spalte, Zeile)) {
					System.err.println("Diese Spalte ist voll");
					pruef=true;
				} else { 
					//System.out.print("test");
					update.setzenvg(Spalte); }; //X oder O wird in Zelle geschrieben
			} else {
				System.err.println("Falsche Eingabe.");
				pruef=true;
			}
			}
			//System.out.print(pruef);
		} while(pruef);
		scanner.close();
	}
}
