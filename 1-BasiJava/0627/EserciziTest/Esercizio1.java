package EserciziTest;

import java.util.Scanner;

public class Esercizio1 {
  public static void main(String[] args) {
    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);

    // Controllo idoneità per un corso avanzato
    boolean idoneo = true;

    // Età
    int età = -1;
    while (idoneo) {
      System.out.print("Inserisci la tua età (>=0): ");
      età = scannerNum.nextInt();
      if (età >= 0) break;
      System.out.println("Inserire un numero valido.");
    }

    // Escluso per sola età
    if (età < 16) {
      System.out.println("Sei troppo giovane per questo corso!");
      idoneo = false;
    }

    // Certificazioni
    int certificazioni = -1;
    while (idoneo) {
      System.out.print("Inserisci quante certificazioni possiedi (>=0): ");
      certificazioni = scannerNum.nextInt();
      if (certificazioni >= 0) break;
      System.out.println("Inserire un numero valido.");
    }

    // Escluso per età e certificazioni
    if (idoneo && età < 18 && certificazioni < 1) {
      System.out.println("Tra i 16 e i 18 anni, per partecipare a questo corso devi avere almeno una certificazione!");
      idoneo = false;
    }

    // Anni di esperienza
    int esperienza = -1;
    while (idoneo) {
      System.out.print("Inserisci i tuoi anni di esperienza (>=0): ");
      esperienza = scannerNum.nextInt();
      if (esperienza >= 0)
        break;
      System.out.println("Inserire un numero valido.");
    }

    // Escluso per età ed esperienza
    if (idoneo && età >= 18 && esperienza < 2) {
      System.out.println("Oltre i 18 anni, per partecipare a questo corso devi avere almeno due anni di esperienza!");
      idoneo = false;
    }

    /*
     * Le condizioni sono separate solo per evitare che il programma chieda sempre
     * tutte le domande anche se l'utente è già stato escluso.
     * 
     * Alternativamente, condensando la logica in un'unica condizione:
     * 
     * if ((16 <= età && età < 18 && certificazioni > 1) ||
     *     (età >= 18 && esperienza >= 2)) {
     *   idoneo = true;
     * } else {
     *   idoneo = false;
     * }
     */

    // Stampa finale
    if (idoneo) {
      System.out.println("Idoneo al corso");
    } else {
      System.out.println("Non idoneo al corso");
    }
    
    // Chiusura scanner
    scannerNum.close();
  }
}
