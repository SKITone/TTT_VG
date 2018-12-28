package Game;

public class Eintragen{
	Spielerwechsel wechsel= new Spielerwechsel();
	Spielfeld Feld= new Spielfeld();
		
	char[][] Zellen =Spielfeld.Zellen;

public void setzenttt(String Spiel, int Spalte, int Zeile) {
	Zellen[Spalte-1][Zeile-1] = wechsel.getSpieler();
	Feld.Anzeigen(Spiel, Spalte, Zeile);
	wechsel.wechseln();
	//System.out.println(wechsel.getSpieler());
	}

public static int vg_Spalte=0;
public static int vg_Zeile=0;
	
public void setzenvg(int Spalte) {
	vg_Zeile=-1;
	vg_Spalte=Spalte-1;
	boolean frei=false;
	
	do {
		vg_Zeile++;
		//System.out.println(vg_Spalte);
		//System.out.println(vg_Zeile);
		if (Zellen[vg_Spalte][vg_Zeile]==' ') {
			frei=true;
		}
		//System.out.println("test setzen");
	} while (frei==false);
	//System.out.println("test setzen 2");
	Zellen[vg_Spalte][vg_Zeile] = wechsel.getSpieler();
	Feld.Anzeigen(Spiel, Spalte, Zeile);
	wechsel.wechseln();
	
	//System.out.println(wechsel.getSpieler());
	}


}

