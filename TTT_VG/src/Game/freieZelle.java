package Game;

public class freieZelle {

	char[][] Zellen = Spielfeld.Zellen;

	
	public boolean besetzt (String Spiel, int Spalte,int Zeile) {
		if (Spiel=="ttt") {return besetztttt(Spalte, Zeile);}
		else {return besetztvg(Spalte);}
	}
		
	public boolean besetztttt(int Spalte,int Zeile) {
		if (Zellen[Spalte-1][Zeile-1]=='X' || Zellen[Spalte-1][Zeile-1]=='O') {
			return false;
		}
		return true;
		}
	
	public boolean besetztvg(int Spalte) {
		
		if (Zellen[Spalte-1][5]==' ') {
			return false;
		}
		return true;
		}


}
