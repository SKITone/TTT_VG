package TTT;

import java.util.Scanner;

import TTT.MinMax.MinMax;

public class StartSpiel {
Spielzug Zug= new Spielzug();
Spielfeld Feld= new Spielfeld();
WinCondition win= new WinCondition();
Spielerwechsel wechsel= new Spielerwechsel();
MinMax minmax=new MinMax();
Scanner scanner= new Scanner(System.in);

char[][] Zellen =Spielfeld.Zellen;
	
public void neuesSpiel(){
	int x = 1;
	do {
	wechsel.setSpieler();										//Startspieler = X festlegen
	//Leerzeichen in Zellen schreiben
	for (int i = 0; i < 3; i++) {								//Zeilen und
        for (int j = 0; j < 3; j++) {							//Spalten erstellen
            Zellen[i][j] = ' ';
        }
    }
	int Zuganzahl=1;
	
	//Feld.ladeSpielfeld();
	//Zellen=Feld.ladeSpielfeldleer();
	//Zuganzahl=7;
	
	Feld.Anzeigen();											//Methode, um Spielfeld anzuzeigen

	boolean unentschieden=false;
	//Spielzug wird solange wiederholt bis einer gewonnen hat oder das Spiel unentschieden endet
	do {
		Zug.Zug();												//Methode, um Spielzug zu realisieren
		//wechsel.wechseln();
		System.out.println("COM: ");
		Feld.setSpielfeld(minmax.COMMove(wechsel.getSpieler(), Zuganzahl+1));
		Feld.Anzeigen();
		Zuganzahl++;
		Zuganzahl++;
		if (Zuganzahl>9) {										//wenn Schleife 9x durchlaufen wird
			unentschieden=true;									//soll diese abgebrochen werden
			break;
		}
	} while (win.gewonnen(Zellen)); 							//Schleife wird abgebrochen, wenn ein Spieler Gewinnbedingung erfüllt	
	
	//Ende
	System.out.println();
	wechsel.wechseln();											//methode, um Spieler zu wechseln
	if (unentschieden) {
		System.out.println("unentschieden");	
	} else {
	System.out.println(wechsel.getSpieler()+" hat gewonnen!");
	}
	
	System.out.println();
	System.out.println("Neues Spiel (beliebeiges Zeichen eingeben");
	String warten= scanner.next();								//erst, wenn eine Taste gedrückt wird, wird neues Spiel gestartet
	} while	(x==1);
	}
}
