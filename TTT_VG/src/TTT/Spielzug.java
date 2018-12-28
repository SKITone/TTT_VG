package TTT;
import java.util.Scanner;

public class Spielzug {
Scanner scanner= new Scanner(System.in);
freieZelle frei= new freieZelle();
Eintragen update= new Eintragen();

public void Zug() {
	
	//Positionsabfrage
	boolean pruef=false;
	do {
		System.out.print("Bitte geben Sie die Spalte an: ");
		int Spalte= scanner.nextInt();														//eingabe
		System.out.print("Bitte geben Sie die Zeile an: ");
		int Zeile= scanner.nextInt();														//eingabe
		pruef=false;
		
		if ((Spalte==1 || Spalte==2 || Spalte==3) && (Zeile==1 || Zeile==2 || Zeile==3)) {	//Kontrolle, ob korrekte Zelle
			if (!frei.besetzt(Spalte, Zeile)) {												//wenn gew‰hlte Zelle nicht besetzt, dann
				System.err.println("Diese Zelle ist besetzt");								//Fehlermeldung
				pruef=true;
			} else { 
				update.setzen(Spalte, Zeile); }; 											//X oder O wird in ausgew‰hlte Zelle geschrieben
		} else {
			System.err.println("Falsche Eingabe.");											//wenn Zelle nicht vorhanden (z.B. zu groﬂe oder kleine Zahl)
			pruef=true;
		}
	} while(pruef);
	}
}

