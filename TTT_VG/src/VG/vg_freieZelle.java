package VG;

import VG.vg_Spielfeld;

public class vg_freieZelle {
char[][] Zellen = vg_Spielfeld.Zellen;

public boolean besetzt(int Spalte) {
	
	if (Zellen[Spalte-1][5]==' ') {
		return false;						//wenn gew�hlte Zelle frei, gib false zur�ck
	}
	return true;							//wenn gew�hlte Zelle besetzt, gib true zur�ck
	}

}
