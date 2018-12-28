package VG.MinMax;

public class Zustand {
	
	char[][] Zellen=new char[7][6];
	int i,j;
	int bewertung;
	int Tiefe;
	
	public Zustand(char[][] Zellen, int Tiefe) {
		this.Zellen=Zellen;
		this.Tiefe=Tiefe;
	}
		
	public Zustand(int i, int j, char[][] Zellen, int Tiefe) {
		this.Zellen=Zellen;
		this.i=i;
		this.j=j;
		this.Tiefe=Tiefe;
	}
	
	public void setBewertung(int bewertung) {
		this.bewertung=bewertung;
	}
}
