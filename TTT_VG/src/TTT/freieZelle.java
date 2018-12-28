package TTT;

public class freieZelle {
char[][] Zellen = Spielfeld.Zellen;

public boolean besetzt(int Spalte,int Zeile) {
	if (Zellen[Spalte-1][Zeile-1]=='X' || Zellen[Spalte-1][Zeile-1]=='O') {
		return false;															//wenn Zelle schon belegt, return false
	}
	return true;
	}

}
