package VG.MinMax;

import java.util.LinkedList;

import VG.*;




public class MinMax {
	Zustand state;
	char[][] Zug;
	char naechsterSpieler;
	LinkedList<Zustand> open= new LinkedList <Zustand>();
	vg_Spielerwechsel wechsel= new vg_Spielerwechsel();
	vg_WinCondition win= new vg_WinCondition();
	vg_Spielfeld Feld= new vg_Spielfeld();
	char[][] ausgangsFeld =vg_Spielfeld.Zellen;
	int Zuganzahl, Tiefe , horizontal, vertikal, diagonal;
	
	
	public char[][] COMMove(int Zuganzahl, char Spieler, int Tiefe, int horizontal, int vertikal, int diagonal){
		state=new Zustand(ausgangsFeld, 0);
		Zug=ausgangsFeld;
		naechsterSpieler=wechsel.getSpieler();
		//System.out.println("in minmax: ");
		//Feld.Anzeigen(Zug);
		this.Tiefe=Tiefe;
		if (Tiefe>42-Zuganzahl) {
			this.Tiefe=42-Zuganzahl;
		}
		this.horizontal=horizontal;
		this.vertikal=vertikal;
		this.diagonal=diagonal;
		this.Zuganzahl=Zuganzahl;
		int bewertung=max(Spieler, state);
		wechsel.setSpieler(naechsterSpieler);
		wechsel.wechseln();
		return Zug;
	}
	
	
	public int max(char Spieler, Zustand zustand) {
		if (zustand.Tiefe == Tiefe || !win.gewonnen(zustand.Zellen)) {
			//System.out.println("test bewertung max");
			return bewerten(true, zustand);
		}
		//System.out.println("test max beginn");
		int maxWert=-1000000;
		LinkedList<Zustand> successor= new LinkedList <Zustand>();
		successor= genNf(Spieler, zustand);									//generiere Mögliche Spielzüge
		while (!successor.isEmpty()) {
			//System.out.println("test max schleife");
			Zustand zs=new Zustand(successor.peek().i, successor.peek().j, successor.peek().Zellen, successor.poll().Tiefe);
			wechsel.wechseln();
			int wert= min(wechsel.getSpieler(), zs);
			//System.out.println("max wert: "+wert);
			wechsel.wechseln();
			if (wert > maxWert) {
				//System.out.println("test max wert vergleich");
				maxWert=wert;
				//System.out.println("aktuelleTiefe: "+zustand.Tiefe+" ZielTiefe: "+state.Tiefe);
				if (zustand.Tiefe==state.Tiefe) {
					for (int x=0; x<7; x++) {
						for (int y=0; y<6; y++) {
							Zug[x][y]=zs.Zellen[x][y];
						}
					}
					System.out.println("max wert: "+wert);
					//Feld.Anzeigen(Zug);
					//System.out.println();
					//System.out.println("test max Zug update");
				}
			}
		}
	return maxWert;	
	}
	
	
	public int min(char Spieler, Zustand zustand) {
		if (zustand.Tiefe == Tiefe || !win.gewonnen(zustand.Zellen)) {
			//System.out.println("test bewertung min");
			return bewerten(false, zustand);
		}
		int minWert=1000000;
		LinkedList<Zustand> successor= new LinkedList <Zustand>();
		successor= genNf(Spieler, zustand);									//generiere Mögliche Spielzüge
		while (!successor.isEmpty()) {
			Zustand zs=new Zustand(successor.peek().i, successor.peek().j, successor.peek().Zellen, successor.poll().Tiefe);
			wechsel.wechseln();
			int wert= max(wechsel.getSpieler(), zs);
			//System.out.println("min wert: "+wert);
			wechsel.wechseln();
			if (wert < minWert) {
				minWert=wert;
				//System.out.println("aktuelleTiefe: "+zustand.Tiefe+" ZielTiefe: "+state.Tiefe);
				if (zustand.Tiefe==state.Tiefe) {
					for (int x=0; x<7; x++) {
						for (int y=0; y<6; y++) {
							Zug[x][y]=zs.Zellen[x][y];
						}
					}
					System.out.println("min wert: "+ wert);
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
		for (int i=0; i<7; i++) {
			boolean abbruch=true;
			int j=0;
			do {
				if (zustand.Zellen[i][j]==' ') {
					abbruch=false;
					char[][] neu= new char[7][6];
					for (int x=0; x<7; x++) {
						for (int y=0; y<6; y++) {
							neu[x][y]=zustand.Zellen[x][y];
						}
					}
					neu[i][j]=Spieler;
					successor.add(new Zustand(i, j, neu, zustand.Tiefe+1));
					//System.out.println(zustand.Tiefe);
					//Feld.Anzeigen(neu);
				}
				j++;
			} while (abbruch && j<6);
		}
		return successor;
	}
	
	public int bewerten(boolean Max, Zustand zustand) {
			
			//int Verteilung = checkVerteilung(zustand, wechsel.getSpieler());
			int myfours = checkforStreak(zustand, wechsel.getSpieler(), 4);
			int mythrees = checkforStreak(zustand, wechsel.getSpieler(), 3);
			int mytwos = checkforStreak(zustand, wechsel.getSpieler(), 2);
			wechsel.wechseln();
			//int oppVerteilung = checkVerteilung(zustand, wechsel.getSpieler());
			int oppfours= checkforStreak(zustand, wechsel.getSpieler(), 4);
			int oppthrees= checkforStreak(zustand, wechsel.getSpieler(), 3);
			int opptwos= checkforStreak(zustand, wechsel.getSpieler(), 2);
			wechsel.wechseln();

			//System.out.println("My Fours: "+myfours+" My Threes: "+mythrees+" My Twos: "+mytwos+" Opp Fours: "+oppfours+" Opp Threes: "+oppthrees+" opp tows:: "+opptwos);
			if (Max) {
				if (oppfours>0) {
					return -100000;
				} else {
				return myfours*100000 + mythrees*1000 + mytwos*1 - oppthrees*1000 - opptwos*1; //+ Verteilung*2 - oppVerteilung;
				}
			} else {
				if (oppfours>0) {
					return 100000;
				} else {
				return -(myfours*100000 + mythrees*1000 + mytwos*1 - oppthrees*1000 - opptwos*1);// + Verteilung*2 - oppVerteilung);
				}
			}
	}
	
	private int checkVerteilung(Zustand zustand, char spieler) {
		int zaehler = 0;;
		for (int x=0; x<7; x++) {
			for (int y=0; y<6; y++) {
				if (zustand.Zellen[x][y]==spieler) {
					zaehler+=(3-Math.abs(3-x))*3;
					zaehler+=(3-Math.abs(2-y))*2;
				}
			}
		}
		return zaehler;
	}


	public int checkforStreak(Zustand zustand, char Spieler, int streak) {
		int zaehler=0;
		
		for (int x=0; x<7; x++) {
			zaehler=zaehler+horizontalStreak(x, Spieler, zustand,streak)*(horizontal+(3-Math.abs(2-x)));
		}
		
		for (int y=0; y<6; y++) {
			zaehler=zaehler+verticalStreak(y,Spieler,zustand,streak)*(vertikal+(6-Math.abs(3-y)*2));
		}
		
		for (int x=1; x<6; x=x+2) {
			for (int y=2; y<4; y++) {
				zaehler=zaehler+diagonalStreak(x,y, Spieler, zustand,streak)*(diagonal+(6-Math.abs(3-x)*2)+(3-Math.abs(2-y)));
			}
		}				
					/*if (streak<4) {
					zaehler=zaehler+(6-Math.abs(3-x)*2)+(3-Math.abs(2-y));
					}*/
		return zaehler;
	}
	
	public int verticalStreak(int y, char Spieler,Zustand zustand,int streak) {
		int zaehler=0;
		int frei=0;
		for (int i=0; i<7; i++) {
			if (zustand.Zellen[i][y]==Spieler || zustand.Zellen[i][y]==' ') {
				if (zustand.Zellen[i][y]==Spieler) {
				zaehler++;
				} else {
					frei++;
				}
				if (zaehler >= streak && zaehler+frei>=4) {
					return 1;
					}	
			} else {
				zaehler=0;
				frei=0;
			}
		}
		return 0;
	}
	
	public int horizontalStreak(int x, char Spieler,Zustand zustand,int streak) {
		int zaehler=0;
		int frei=0;
		for (int j=0; j<6; j++) {
			if (zustand.Zellen[x][j]==Spieler || zustand.Zellen[x][j]==' ') {
				if (zustand.Zellen[x][j]==Spieler) {
				zaehler++;
				} else {
					frei++;
				}
				if (zaehler >= streak && zaehler+frei>=4) {
					return 1;
					}	
			} else {
				zaehler=0;
				frei=0;
			}
		}
		return 0;
	}
	
	public int diagonalStreak(int x, int y, char Spieler, Zustand zustand,int streak) {
		int zaehler=0;
		
		//steigend
		int steigendzaehler=0;
		int steigendfrei=0;
		int i=x;
		int j=y;
		while (i>0 && j>0) {
			i--;
			j--;
		}

		while (i<7 && j<6) {
			if (zustand.Zellen[i][j]==Spieler || zustand.Zellen[i][j]==' ') {
				if (zustand.Zellen[i][j]==Spieler) {
				steigendzaehler++;
				} else {
					steigendfrei++;
				}
				if (steigendzaehler >= streak && steigendzaehler+steigendfrei>=4) {
					zaehler++;
					break;
					}	
			} else {
				steigendzaehler=0;
				steigendfrei=0;
			}
			i++;
			j++;
		}
		
		//fallend
		int fallendzaehler=0;
		int fallendfrei=0;
		i=x;
		j=y;
		while (i>0 && j<5) {
			i--;
			j++;
		}
		
		while (i<7 && j>=0) {
			if (zustand.Zellen[i][j]==Spieler || zustand.Zellen[i][j]==' ') {
				if (zustand.Zellen[i][j]==Spieler) {
				fallendzaehler++;
				} else {
					fallendfrei++;
				}
				if (fallendzaehler >= streak && fallendzaehler+fallendfrei>=4) {
					zaehler++;
					break;
					}	
			} else {
				fallendzaehler=0;
				fallendfrei=0;
			}
			i++;
			j--;
		}

		return zaehler;
	}
}
