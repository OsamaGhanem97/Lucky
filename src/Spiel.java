import java.util.Scanner;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare!
 * Fuegen Sie Code hinzu!
 * Aendern Sie vom vorhandenen Code nur return-Anweisungen!
 ****************************************************************************************************** */

public class Spiel {

	/* Verwenden Sie unbedingt diese Klassenattribute in den Methoden der Klasse! */
    private static Scanner sc = new Scanner(System.in);
    public static Spieler spieler1;
    public static Spieler spieler2;
    public static Zahlenstapel stapel;

    public static void main(String[] args) {
        System.out.println("Herzlich Willkommen zu Lucky Numbers Light");

        int eingabe;
        boolean spielen = true;

        do {
            eingabe = menu();

            if (eingabe == 1) {
            	/*
				 * Methoden spielVorbereiten() und spielen() aufrufen
				 
				 */
				// TODO
				// Anweisung(en) hinzufuegen
            	spielVorbereiten();
            	spielen();
       
            }else {
            	spielen=false;
            }

            /* Dafuer sorgen, dass bei Eingabe 2 das Programm endet */
			// TODO
			// Anweisung(en) hinzufuegen

        } while (spielen);

        System.out.println("Programm beendet.");
        sc.close();
    }

    /*
     * Fragt solange nach einer Menu-Eingabe bis eine erlaubte Zahl eingegeben wird.
     * Methode checkEingabeMenu() verwenden
     */
    public static int menu() {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aender
    	int eingabe;
    	do {
    		System.out.println("Lucky Numbers Light");
    		System.out.println("1- Spielen starten");
    		System.out.println("2- Programm beenden");
    		eingabe=sc.nextInt();
    		
    	}while(!checkEingabeMenu(eingabe));
    	return eingabe;
    }

    /*
     * Gibt bei Eingabe von 1 oder 2 true zurueck. Sonst false.
     */
    public static boolean checkEingabeMenu(int eingabe) {
		// TODO
		// ggf Anweisungen hinzufuegen  
			
		// unbedingt return-Anweisung aendern
    	if(eingabe==1||eingabe==2) {
    		return true;
    	}
        return false;
    }

    /*
     * Liest die Namen der beiden Spieler sowie die Groesse des Spielfelds ein 
     * Erzeugt die Spieler und den Zahlenstapel.
     */
    public static void spielVorbereiten() {
		// TODO
		// Anweisung(en) hinzufuegen
    	System.out.println("Gib den Namen von Spieler 1 ein:  ");
    	String name1=sc.next();
    	System.out.println("Gib den Namen von Spieler 2 ein:  ");
    	String name2=sc.next();
    	System.out.println("Wie gross soll das Spiefeld sein? ");
    	int n=sc.nextInt();
    	spieler1=new Spieler(name1,n);
    	spieler2=new Spieler(name2,n);
    	stapel=new Zahlenstapel(6*n,n-1);
    	
    	
    	}

    /*
     * Es wird gespielt, bis ein Spielfeld eines Spielers voll ist oder der Zahlenstapel leer ist.
     * Die Spieler sind abwechselnd an der Reihe. 
     * Methoden spielzug(), Spieler.getSpielfeld(), Spielfeld.istVoll(), Zahlenstapel.istLeer() verwenden.
     */
    public static void spielen() {
		// TODO
		// Anweisung(en) hinzufuegen
        
        // NICHT AENDERN
    	while(!spieler1.getSpielfeld().istVoll()&&!spieler2.getSpielfeld().istVoll()&&!stapel.istLeer()) {
    		spielzug(spieler1);
    		if(!spieler1.getSpielfeld().istVoll()&&!stapel.istLeer()) {
    			spielzug(spieler2);
    		}
    	}
        System.out.println(auswertung());
    }

    /*
     * Der Spieler zieht eine Zahl vom Zahlenstapel.
     * Danach entscheidet er, ob er sie verwenden moechte.
     * Dafuer wird solange nach einer korrekten Eingabe (j, ja, n, nein) gefragt, bis diese erfolgt
     * Methoden Spieler.getSpielfeld(), Spieler,getName(),
     * Zahlenstapel.zieheZahl(), Zahlenstapel.anzahlUebrigeZahlen() und zahlSetzen() verwenden
     */
    public static void spielzug(Spieler spieler) {
    	// Diese Zeilen NICHT AENDERN
        System.out.println("--------------------------------");
        System.out.println(spieler.getName() + " ist an der Reihe.");
        
        System.out.println("Spielfeld von " + spieler.getName() + ":");
        System.out.println(spieler.getSpielfeld());
           int zahl=stapel.zieheZahl();
        System.out.println("Gezogen Zahl :"+zahl);
        System.out.println("Anzahl uebrige Zahlen im Stapel: "+stapel.anzahlUebrigeZahlen());
        String eingabe=null;
        do {
        	System.out.println("Moechtest du die Zahl verwenden/n(j/ja/n/nein)");
        	eingabe=sc.next();
        }while(!eingabe.equals("j")&&!eingabe.equals("ja")&&!eingabe.equals("n")&&!eingabe.equals("nein"));
        
        if(eingabe.equals("j")||eingabe.equals("ja")) {
        	zahlSetzen(spieler,zahl);
        }
        if(eingabe.equals("n")||eingabe.equals("nein")) {
    		return;
    	}
        
		// TODO
		// Anweisung(en) hinzufuegen        
    }

    /*
     * Fragt solange nach Zeile und Spalte, bis die Zahl gueltig gesetzt wurde
     * oder der Spieler die Zahl wegwirft.
     * Methoden Spieler.getSpielfeld(), Spielfeld.gueltigeEingabe(), Spielfeld.setStelle() verwenden
     */
    public static void zahlSetzen(Spieler spieler, int zahl) {
    	int zeile;
        int spalte;
        String eingabe;
        boolean gesetzt = false;

        do {
            System.out.print("Zeile: ");
            zeile = sc.nextInt();

            System.out.print("Spalte: ");
            spalte = sc.nextInt();
            if(spieler.getSpielfeld().gueltigeEingabe(zeile, spalte, zahl)) {
            	spieler.getSpielfeld().setStelle(zeile, spalte, zahl);
            	gesetzt=true;
            }else {
            	String eingabe1;
            	do {
            		System.out.println("Diese Eingabe ist nicht gueltig.");
                	System.out.println("Ander Postion versuchen?/n(j/ja/n/nein)");
                	eingabe1=sc.next();
            	}while(!eingabe1.equals("j")||eingabe1.equals("ja")||eingabe1.equals("n")||eingabe1.equals("nein"));
            	if(eingabe1.equals("n")||eingabe1.equals("nein")) {
            		return;
            	}
            }

    		// TODO
    		// Anweisung(en) hinzufuegen
            
        } while (!gesetzt);
    }

    /*
     * NICHT AENDERN!
     * Wird bereits an der richtigen Stelle aufgerufen.
     */
    public static String auswertung() {
        if (spieler1.getSpielfeld().istVoll()) {
            return spieler1.getName() + " hat gewonnen!";
        }

        if (spieler2.getSpielfeld().istVoll()) {
            return spieler2.getName() + " hat gewonnen!";
        }

        return "Der Stapel ist leer. Niemand hat gewonnen.";
    }
}