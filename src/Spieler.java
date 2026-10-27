/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare!
 * Fuegen Sie Code hinzu!
 * Aendern Sie vom vorhandenen Code nur return-Anweisungen!
 ****************************************************************************************************** */

class Spieler {

	private String name;
	private Spielfeld sf;

	/* 
	 * Vervollstaendigen Sie den Konstruktor. 
	 */
	public Spieler(String name, int n) {
		// TODO
		// Anweisung(en) hinzufuegen
		this.name=name;
		sf=new Spielfeld(n);
	}

	/* 
	 * Vervollstaendigen Sie die Getter-Methode 
	 */
	public String getName() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return name;
	}

	/* 
	 * Vervollstaendigen Sie die Getter-Methode 
	 */
	public Spielfeld getSpielfeld() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
		return sf;
	}

}