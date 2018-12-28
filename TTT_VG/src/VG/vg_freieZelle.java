package VG;

import VG.vg_Spielfeld;

public class vg_freieZelle {
char[][] Zellen = vg_Spielfeld.Zellen;

public boolean besetzt(int Spalte) {
	
	if (Zellen[Spalte-1][5]==' ') {
		return false;						//wenn gewählte Zelle frei, gib false zurück
	}
	return true;							//wenn gewählte Zelle besetzt, gib true zurück
	}

}
