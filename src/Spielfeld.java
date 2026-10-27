/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare der einzelnen Methoden!
 * Fuegen Sie Code, insbesondere weitere Methoden, hinzu!
 * Aendern Sie vom vorhandenen Code nur die return-Anweisungen
 ****************************************************************************************************** */

public class Spielfeld {
	private int[][] feld;
	private int n;

	/* 
	 * Vervollstaendigen Sie den Konstruktor. 
	 */
	public Spielfeld(int n) {
		// TODO
		// Anweisung(en) hinzufuegen
		this.n=n;
		feld=new int[n][n];
		
	}
	
	/*
	 * NICHT AENDERN! Fuer Testzwecke!
	 */
	public Spielfeld(int[][] feld) {
		this.feld = feld;
		this.n = feld.length;  
	}

	/*
	 * NICHT AENDERN! Fuer Testzwecke!
	 */
	public int getN() {
		return n;
	}
	
	/*
	 * NICHT AENDERN! Fuer Testzwecke!
	 */
	public int getStelle(int zeile, int spalte) {
		return feld[zeile][spalte];
	}
	
	/*
	 * Setzt zahl an Stelle (zeile, spalte) in feld. Es ist sichergestellt, dass die
	 * Methode nur mit gueltigen Werten aufgerufen wird.
	 */
	public void setStelle(int zeile, int spalte, int zahl) {
		// TODO
		// Anweisung(en) hinzufuegen
		feld[zeile][spalte]=zahl;
	}
	
	/* 
	 * Gibt true zurueck, wenn zahl an Stelle (zeile,spalte) geschrieben werden darf,
	 * false sonst 
	 */
	public boolean gueltigeEingabe(int zeile, int spalte, int zahl) {
		
		// Sind (zeile,spalte) gueltige Koordinaten des Feldes?
		// TODO
		// Anweisung(en) hinzufuegen
		if(zeile<0||zeile>=n||spalte<0||spalte>=n) {
			return false;
		}


		// Ist die Stelle (zeile, spalte) im Feld frei?
		// TODO
		// Anweisung(en) hinzufuegen
		if(feld[zeile][spalte]!=0) {
			return false;
		}


		// Links pruefen: ALLE vorhandenen Zahlen ungleich 0 links der Stelle (zeile, spalte) in Zeile zeile muessen kleiner gleich sein
		// TODO
		// Anweisung(en) hinzufuegen
		for(int j=0;j<spalte;j++ ) {
			if(feld[zeile][j]!=0&&feld[zeile][j]>zahl) {
				return false;
			}
		}


	    // Rechts pruefen: ALLE vorhandenen Zahlen ungleich 0 rechts der Stelle (zeile, spalte) in Zeile zeile muessen groesser gleich sein
		// TODO
		// Anweisung(en) hinzufuegen
		for(int j=spalte+1;j>feld.length;j++) {
			if(feld[zeile][j]!=0&&feld[zeile][j]<zahl) {
				return false;
			}
		}


	    // Oben pruefen: ALLE vorhandenen Zahlen ungleich 0 ueber der Stelle (zeile, spalte) in Spalte spalte muessen kleiner gleich sein
		// TODO
		// Anweisung(en) hinzufuegen
		for(int i=0;i<zeile;i++) {
			if(feld[i][spalte]!=0&&feld[i][spalte]>zahl) {
				return false;
			}
		}


	    // Unten pruefen: ALLE vorhandenen Zahlen ungleich 0 unter der Stelle (zeile, spalte) in Spalte spalte muessen groesser gleich sein
		// TODO
		// Anweisung(en) hinzufuegen
		for(int i=zeile+1;i<n;i++) {
			if(feld[i][spalte]!=0&&feld[i][spalte]<zahl) {
				return false;
			}
		}

		
		// TODO
		// return-Anweisung ggf. aendern    
		return true;
	}
	
	/* 
	 * Gibt true zurueck, wenn feld voll besetzt ist,
	 * also keine 0 mehr enthaelt;
	 * sonst false.
	 */
	public boolean istVoll() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		for(int i=0;i<feld.length;i++) {
			for(int j=0;j<feld.length;j++) {
				if(feld[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}

	/* 
	 * NICHT AENDERN! 
	 * Verwenden Sie die Methode zur Ausgabe des Spielfeldes
	  */
	public String toString() {
        String ausgabe = ""; 

        ausgabe += "     "; 
        for (int spalte = 0; spalte < n; spalte++) {
            ausgabe += String.format("%4d", spalte);
        }
        ausgabe += "\n";

        ausgabe += "----+";
        for (int spalte = 0; spalte < n; spalte++) {
            ausgabe += "----";
        }
        ausgabe += "\n";

        for (int zeile = 0; zeile < n; zeile++) {
            
            ausgabe += String.format("%3d |", zeile);

            for (int spalte = 0; spalte < n; spalte++) {
                if (feld[zeile][spalte] == 0) {
                    ausgabe += String.format("%4s", "-"); 
                } else {
                    ausgabe += String.format("%4d", feld[zeile][spalte]);
                }
            }

            ausgabe += "\n";
        }

        return ausgabe;
    }
}