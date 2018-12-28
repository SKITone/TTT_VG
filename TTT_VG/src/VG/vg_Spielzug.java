package VG;

import java.util.Scanner;

import VG.vg_Eintragen;
import VG.vg_freieZelle;

public class vg_Spielzug {
Scanner scanner= new Scanner(System.in);
vg_freieZelle frei= new vg_freieZelle();
vg_Eintragen update= new vg_Eintragen();

public void Zug() {
	
	//Positionsabfrage
	boolean pruef=false;
	do {
		System.out.print("Bitte geben Sie die Spalte an: ");
		int Spalte= scanner.nextInt();								//eingabe
		pruef=false;
		
		//System.out.print(Spalte);
		
		if (Spalte>0 && Spalte<8) {
			if (frei.besetzt(Spalte)) {								//Methode, um zu kontrollieren, ob Zelle besetzt 
				System.err.println("Diese Spalte ist voll");
				pruef=true;
			} else { 
				//System.out.print("test");
				update.setzen(Spalte); }; 							//Methode, um Zelle mit X/O zu besetzen
		} else {
			System.err.println("Falsche Eingabe.");					//bei zu großer oder zu kleiner Eingabe
			pruef=true;
		}
		//System.out.print(pruef);
	} while(pruef);
	
	
	}
}