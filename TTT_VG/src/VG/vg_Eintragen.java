package VG;

import VG.vg_Spielerwechsel;
import VG.vg_Spielfeld;

public class vg_Eintragen {
vg_Spielerwechsel wechsel= new vg_Spielerwechsel();
vg_Spielfeld Feld= new vg_Spielfeld();
	
char[][] Zellen =vg_Spielfeld.Zellen;

public static int vg_Spalte=0;
public static int vg_Zeile=0;
	
public void setzen(int Spalte) {
	vg_Zeile=-1;
	vg_Spalte=Spalte-1;
	boolean frei=false;
	
	do {
		vg_Zeile++;
		if (Zellen[vg_Spalte][vg_Zeile]==' ') {				//Suche die niedrigste freie Zelle in der Spalte
			frei=true;
		}
	} while (frei==false);
	Zellen[vg_Spalte][vg_Zeile] = wechsel.getSpieler();		//Setze X/O in ausgewählte Zelle
	Feld.Anzeigen();										//Spielfeld schreiben
	wechsel.wechseln();										//spieler wechseln
	}

}
