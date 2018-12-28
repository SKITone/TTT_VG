package Game;

import java.util.Scanner;

public class Menu {
	
	SpielStart spielstart= new SpielStart();
	Scanner scanner= new Scanner(System.in);
	
	public void Hauptmenu() {
		System.out.println("-----------");
		System.out.println("-Hauptmenü-");
		System.out.println("-----------");
		System.out.println();
		System.out.println();
		
		String Spiel=waehleSpiel();
		String Modus=waehleSpieleranzahl();

		scanner.close();
		
		spielstart.starteSpiel(Spiel, Modus);
		
	}
	
	public String waehleSpiel() {
		//Scanner scanner= new Scanner(System.in);
		
		boolean pruef;
		String wahl;
		do {
			
		System.out.println("Wollen Sie Tic Tac Toe oder Vier Gewinnt spielen?");
		System.out.println("Für Tic Tac Toe geben Sie 'ttt' ein.");
		System.out.println("Für Vier Gewinnt geben Sie 'vg' ein.");

		pruef=true;
		
		wahl=scanner.nextLine();
		
		//System.out.println(wahl);
		
		if ((wahl.equals("ttt")) || (wahl.equals("vg"))) {pruef=false;} else {
			System.out.println("ungültige Eingabe.");
		}
		} while (pruef);
		
		//scanner.close();

		return wahl;
	}

	public String waehleSpieleranzahl() {
		//Scanner scanner= new Scanner(System.in);
		
		boolean pruef;
		String wahl="";
		do {
			
		System.out.println("Wollen Sie allein gegen einen Computer oder zu Zweit spielen?");
		System.out.println("Wenn Sie gegen einen COM spielen wollen schreiben Sie 'COM'");
		System.out.println("Wenn Sie zu Zweit spielen wollen schreiben Sie '2P'");

		pruef=true;
		
		wahl=scanner.nextLine();
		
		System.out.println(wahl);

		
		if ((wahl.equals("COM")) || (wahl.equals("2P"))) {pruef=false;} else {
			System.out.println("ungültige Eingabe.");
		}
		} while (pruef);
		
		//scanner.close();
		
		return wahl;
	}
}
