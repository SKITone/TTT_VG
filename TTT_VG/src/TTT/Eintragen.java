package TTT;

public class Eintragen {
Spielerwechsel wechsel= new Spielerwechsel();
Spielfeld Feld= new Spielfeld();
	
char[][] Zellen =Spielfeld.Zellen;
	
public void setzen(int Spalte, int Zeile) {
	Zellen[Spalte-1][Zeile-1] = wechsel.getSpieler();		//aktuelles Spielersymbpl in gewählte Zelle schreiben
	Feld.Anzeigen();										//spielfeld "zeichnen"
	wechsel.wechseln();										//Spieler wechseln
	}

}
