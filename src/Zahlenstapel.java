import java.util.Random;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare der einzelnen Methoden!
 * Fuegen Sie Code, insbesondere weitere Methoden, hinzu!
 * Aendern Sie vom vorhandenen Code nur die return-Anweisungen
 ****************************************************************************************************** */

public class Zahlenstapel {
	private int[] zahlen;
	private int naechsterIndex;
	private Random rd;

	/*
	 * NICHT AENDERN! Verwenden Sie diesen Konstruktor
	 */
	public Zahlenstapel(int maxZahl, int anzahlProZahl) {
		this.zahlen = new int[maxZahl * anzahlProZahl];
		this.naechsterIndex = 0;
		this.rd = new Random();

		initialisiere(maxZahl, anzahlProZahl);
		mischen();
	}

	/*
	 * NICHT AENDERN! Initialisiert das Feld zahlen nach den Vorgaben. Zuerst wird
	 * die 1 anzahlproZahl oft eingetragen, dann die 2 usw. bis inkl. maxZahl.
	 * Beispiel initialisiere(4,2): zahlen = {1,1,2,2,3,3,4,4} (jede Zahl von 1 bis
	 * 4 zweimal, genau in der Reihenfolge)
	 */
	public void initialisiere(int maxZahl, int anzahlProZahl) {
		int index = 0;
		for (int zahl = 1; zahl <= maxZahl; zahl++) {
			for (int i = 0; i < anzahlProZahl; i++) {
				zahlen[index] = zahl;
				index++;
			}
		}
	}

	/*
	 * Mischen Sie das zuvor initialisierte Feld zahlen. Nutzen Sie den Algorithmus
	 * aus der Aufgabenstellung.
	 */
	public void mischen() {
		// TODO
		// Anweisung(en) hinzufuegen

		for (int i = zahlen.length-1; i > 0; i--) {
			int zufallsIndex = rd.nextInt(0, i + 1);
			int temp = zahlen[i];
			zahlen[i] = zahlen[zufallsIndex];
			zahlen[zufallsIndex] = temp;
		}
	}

	/*
	 * NICHT AENDERN! Fuer Testzwecke!
	 */
	public int getZahl(int index) {
		return zahlen[index];
	}

	/*
	 * Geben Sie die naechste Zahl vom Stapel zurueck. Verwenden Sie dafür das
	 * Attribut naechsterIndex. Achten Sie auch darauf, das Attribut nach dem Ziehen
	 * entsprechend zu aendern. Wenn der Stapel leer ist, geben Sie eine -1 zurueck.
	 */
	public int zieheZahl() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		if (naechsterIndex >= zahlen.length) {
			return -1;
		}
		int zahl = zahlen[naechsterIndex];
		naechsterIndex++;
		return zahl;
	}

	/*
	 * Gibt true zurueck, wenn der Stapel leer ist; false sonst. Ueberlegen Sie, wie
	 * Sie dies anhand des Attributs naechsterIndex feststellen koennen.
	 */
	public boolean istLeer() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		if (naechsterIndex >= zahlen.length) {
			return true;
		}
		return false;
	}

	/*
	 * Geben Sie zurueck, wie viele Zahlen noch auf dem Stapel vorhanden sind.
	 */
	public int anzahlUebrigeZahlen() {
		// TODO
		// ggf Anweisungen hinzufuegen

		// unbedingt return-Anweisung aendern
		return zahlen.length - naechsterIndex;
	}
}