package TTT.MinMax;

import java.util.LinkedList;

import TTT.*;




public class MinMax {
	Zustand state;
	char[][] Zug;
	char naechsterSpieler;
	LinkedList<Zustand> open= new LinkedList <Zustand>();
	Spielerwechsel wechsel= new Spielerwechsel();
	WinCondition win= new WinCondition();
	Spielfeld Feld= new Spielfeld();
	char[][] ausgangsFeld =Spielfeld.Zellen;
	
	
	public char[][] COMMove( char Spieler, int Tiefe){
		state=new Zustand(ausgangsFeld, Tiefe);
		Zug=ausgangsFeld;
		naechsterSpieler=wechsel.getSpieler();
		//System.out.println("in minmax: ");
		//Feld.Anzeigen(Zug);
		int bewertung=max(Spieler, state);
		wechsel.setSpieler(naechsterSpieler);
		wechsel.wechseln();
		return Zug;
	}
	
	
	public int max(char Spieler, Zustand zustand) {
		if (zustand.Tiefe == 10 || !win.gewonnen(zustand.Zellen)) {
			//System.out.println("test bewertung");
			return bewerten(true, zustand);
		}
		//System.out.println("test max beginn");
		int maxWert=-20;
		LinkedList<Zustand> successor= new LinkedList <Zustand>();
		successor= genNf(Spieler, zustand);									//generiere Mögliche Spielzüge
		while (!successor.isEmpty()) {
			//System.out.println("test max schleife");
			Zustand zs=new Zustand(successor.peek().Zellen, successor.poll().Tiefe);
			wechsel.wechseln();
			int wert= min(wechsel.getSpieler(), zs);
			//System.out.println("max wert: "+wert);
			wechsel.wechseln();
			if (wert > maxWert) {
				//System.out.println("test max wert vergleich");
				maxWert=wert;
				//System.out.println("aktuelleTiefe: "+zustand.Tiefe+" ZielTiefe: "+state.Tiefe);
				if (zustand.Tiefe==state.Tiefe) {
					for (int x=0; x<=2; x++) {
						for (int y=0; y<=2; y++) {
							Zug[x][y]=zs.Zellen[x][y];
						}
					}
					//System.out.println(wert);
					//Feld.Anzeigen(Zug);
					//System.out.println();
					//System.out.println("test max Zug update");
				}
			}
		}
	return maxWert;	
	}
	
	
	public int min(char Spieler, Zustand zustand) {
		if (zustand.Tiefe == 10 || !win.gewonnen(zustand.Zellen)) {
			//System.out.println("test bewertung");
			return bewerten(false, zustand);
		}
		int minWert=20;
		LinkedList<Zustand> successor= new LinkedList <Zustand>();
		successor= genNf(Spieler, zustand);									//generiere Mögliche Spielzüge
		while (!successor.isEmpty()) {
			Zustand zs=new Zustand(successor.peek().Zellen, successor.poll().Tiefe);
			wechsel.wechseln();
			int wert= max(wechsel.getSpieler(), zs);
			//System.out.println("min wert: "+wert);
			wechsel.wechseln();
			if (wert < minWert) {
				minWert=wert;
				//System.out.println("aktuelleTiefe: "+zustand.Tiefe+" ZielTiefe: "+state.Tiefe);
				if (zustand.Tiefe==state.Tiefe) {
					for (int x=0; x<=2; x++) {
						for (int y=0; y<=2; y++) {
							Zug[x][y]=zs.Zellen[x][y];
						}
					}
					//System.out.println(wert);
					//Feld.Anzeigen(Zug);
					//System.out.println();
					//System.out.println("test");
				}
			}
		}
		return minWert;	
	}
	
	
	
	public LinkedList<Zustand> genNf(char Spieler, Zustand zustand) {
		//System.out.println("test in genNf");
		LinkedList<Zustand> successor= new LinkedList <Zustand>();
		//char[][] neu=new char[3][3];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (zustand.Zellen[i][j]==' ') {
					
					char[][] neu= new char[3][3];
					for (int x=0; x<=2; x++) {
						for (int y=0; y<=2; y++) {
							neu[x][y]=zustand.Zellen[x][y];
						}
					}
					neu[i][j]=Spieler;
					//Feld.Anzeigen(neu);
					successor.add(new Zustand(neu, zustand.Tiefe+1));
					//System.out.println(zustand.Tiefe);
					//Feld.Anzeigen(neu);
				}
			}
		}
		return successor;
	}
	
	public int bewerten(boolean Max, Zustand zustand) {
		if (win.gewonnen(zustand.Zellen)) {
			return 0;
		} else {
			if (Max) {
				return -20 + zustand.Tiefe;
			} else {
				return 20 - zustand.Tiefe;
			}
		}
	}
}
