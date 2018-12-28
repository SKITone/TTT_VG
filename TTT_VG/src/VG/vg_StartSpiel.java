package VG;

import java.util.Scanner;

import VG.MinMax.MinMax;
import VG.vg_Spielerwechsel;
import VG.vg_Spielfeld;
import VG.vg_Spielzug;
import VG.vg_WinCondition;

public class vg_StartSpiel {
vg_Spielzug Zug= new vg_Spielzug();
vg_Spielfeld Feld= new vg_Spielfeld();
vg_WinCondition win= new vg_WinCondition();
vg_Spielerwechsel wechsel= new vg_Spielerwechsel();
MinMax minmax=new MinMax();
Scanner scanner= new Scanner(System.in);

public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_YELLOW = "\u001B[33m";

char[][] Zellen =vg_Spielfeld.Zellen;
	
public void neuesSpiel(){
	int x = 1;
	do {
	wechsel.setSpieler();
	//Leerzeichen in Zellen schreiben
	for (int i = 0; i < 7; i++) {					//doppelte Schleife, alle um Zellen mit dem Wert ' ' zu füllen
        for (int j = 0; j < 6; j++) {
            Zellen[i][j] = ' ';
        }
    }
	
	Feld.Anzeigen();														//Methode, um aktuelles Feld zu schreiben
	int Zuganzahl=0;
	boolean unentschieden=false;
	//Spielzug wird solange wiederholt bis einer gewonnen hat oder das Spiel unentschieden endet
	do {
		//Zug.Zug();														//Methode, um Spielzug auszuführen
		System.out.println("COM 1: ");
		Feld.setSpielfeld(minmax.COMMove(Zuganzahl, wechsel.getSpieler(), 5, 15, 20, 25));
		Feld.Anzeigen();
		if (!win.gewonnen(Zellen)) {
			//System.out.println("test oben");
			break;
		}
		System.out.println("COM 2: ");
		Feld.setSpielfeld(minmax.COMMove(Zuganzahl+1, wechsel.getSpieler(), 5, 15, 20, 25));
		Feld.Anzeigen();
		if (!win.gewonnen(Zellen)) {
			//System.out.println("test unten");
			break;
		}
		//Zug.Zug();
		Zuganzahl++;
		Zuganzahl++;
		//System.out.println(Zuganzahl);
		if (Zuganzahl>42) {													//nach 42 Zügen ohne Sieg => unentschieden
			unentschieden=true;
			//System.out.println("unentschieden");
			break;
		}
	} while (win.gewonnen(Zellen, vg_Eintragen.vg_Spalte, vg_Eintragen.vg_Zeile));	//wenn WinCondition erfüllt => Sclheife abbrechen
	
	//Ende
	System.out.println();
	
	wechsel.wechseln();														//Spieler wechseln
	//System.out.println(wechsel.getSpieler());
	if (unentschieden) {
		System.out.println("unentschieden");
	} else {
		if (wechsel.getSpieler()=='X') {
			//System.out.println(ANSI_RED+"O"+ANSI_RESET+" hat gewonnen!");
			System.out.println("X hat gewonnen");
	} else {
		//System.out.println(ANSI_YELLOW+"O"+ANSI_RESET+" hat gewonnen!");	
		System.out.println("O hat gewonnen");
	}
	}
	
	System.out.println();
	System.out.println("Neues Spiel (beliebiges Zeichen eingeben)");
	String warten= scanner.next();
	} while	(x==1);
	}
}

