package TTT.MinMax;

public class Zustand {
	
	char[][] Zellen=new char[3][3];
	int bewertung;
	int Tiefe;
	
		
	public Zustand(char[][] Zellen, int Tiefe) {
		this.Zellen=Zellen;
		this.Tiefe=Tiefe;
	}
	
	public void setBewertung(int bewertung) {
		this.bewertung=bewertung;
	}
}
