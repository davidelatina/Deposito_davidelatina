package EserciziTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio2 {
  public static void main(String[] args) {
    /*
     * Traccia: Lista della spesa intelligente
     * Usa un ArrayList<String> per memorizzare gli articoli della spesa
     * Chiede all’utente di inserire elementi finché non scrive "fine"
     * Dopo l’inserimento, stampa:
     * 
     * Tutti gli elementi della lista (uno per riga)
     * 
     * Il numero totale di elementi inseriti
     * 
     * Se l’utente ha scritto sia "pane" e "latte" (usa .contains() e un if),
     * stampa: "Hai pensato alla colazione!"
     */

    // Dichiarazione scanner
    Scanner scannerString = new Scanner(System.in);

    // Crea arraylist di stringhe 
    ArrayList<String> articoli = new ArrayList<>();

    // variabile temporanea per controllare gli articoli nel primo ciclo,
    // e per controllare se sono presenti pane e latte nel secondo.
    String stringTemp = "";

    // Inserimento lista spesa. Ciclo termina se utente scrive "fine"
    while (true) {
      System.out.print("Inserire articoli da comprare, o \"fine\": ");
      stringTemp = scannerString.nextLine();
      stringTemp.trim();
      
      // utente aggiunge articoli finché non scrive "fine"
      if (stringTemp.equalsIgnoreCase("fine")) {
        System.out.println("Fine inserimento articoli.");
        break;
      } else if (stringTemp.isBlank()) {
        System.out.println("Inserire una stringa valida.");
      } else {
        articoli.add(stringTemp);
      }
    }

    // stampare numero totale di articoli inseriti
    System.out.println("Inseriti " + articoli.size() + " articoli:");

    // stampare tutti gli articoli in lista, e controllare se ci sono pane e latte
    boolean pane = false;
    boolean latte = false;
    for (int i = 0; i < articoli.size(); i++) {
      // salva stringa per verifica
      stringTemp = articoli.get(i);

      // stampa articolo in lista
      System.out.println("\t" + stringTemp);

      // verifica se pane e latte sono presenti
      if (!pane) {
        if (stringTemp.equalsIgnoreCase("pane"))
          pane = true;
      }
      if (!latte) {
        if (stringTemp.equalsIgnoreCase("latte"))
          latte = true;
      }
    }
     
    // L'utente ha pensato alla colazione.
    if (pane && latte)
      System.out.println("Hai pensato alla colazione!");
    
    // chiusura scanner
    scannerString.close();
  }
}
