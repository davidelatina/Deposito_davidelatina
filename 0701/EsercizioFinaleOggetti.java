/*
Gestione Semplice di una Autoofficina
Obiettivo: Allenati con la creazione e l’uso di classi e oggetti in Java.
Traccia:
Realizza almeno due classi:
  Classe Auto:
  Attributi:
    targa (String)
    modello (String)
  Classe Officina:
  Attributi:
    Un array o un ArrayList di auto (Auto[] o ArrayList<Auto>)
    Un metodo per aggiungere un’auto all’officina
    Un metodo per stampare l’elenco di tutte le auto presenti
  Obblighi minimi:
    Permetti di aggiungere almeno due auto diverse all’officina.
    Stampa a schermo l’elenco di tutte le auto con targa e modello
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioFinaleOggetti {
  public static void main(String[] args) {
    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    // scelta utente
    String[] menuStrings = {
      "Gestione Autoofficina",
      "Aggiungi Auto",
      "Lista Auto",
      "Esci"};
    int scelta = -1;

    // Autoofficina
    Officina autoofficina = new Officina();

    autoofficina.addAuto("AB001CD", "Fiat Panda");
    autoofficina.addAuto("AB002CD", "Volkswagen Polo");

    // Stringhe in input
    String bufferString1 = "";
    String bufferString2 = "";


    while (true) { // Loop principale programma

      // Menu di selezione
      scelta = menuInt(scannerNum, menuStrings);
      
      // Uscita programma
      if (scelta == menuStrings.length-1) break; // <-- USCITA LOOP E PROGRAMMA

      // Funzionalità scelta
      switch (scelta) {
        case 1: // Aggiungi Auto

          // Inserimento targa univoca
          bufferString1 = verifiedInputString(
            scannerStr, "Inserisci targa auto: ",
            "Inserire una stringa valida.",
            false, false, false);
            
          // Inserimento modello
          bufferString2 = verifiedInputString(
            scannerStr, "Inserisci modello auto: ", 
            "Inserire una stringa valida.", 
            false, false, false);

          // Auto aggiunta a autoofficina
          autoofficina.addAuto(bufferString1, bufferString2);
          break;
      
        case 2: // Lista Auto
          autoofficina.printAutos();
          break;

        default: // Non dovrebbe essere raggiungibile
          System.out.println("Errore selezione");
          break;
      }
    }

    // Chiusura scanner
    scannerNum.close();
    scannerStr.close();
  }

  /**
   * @brief             Menu di selezione a interi.
   *            
   *                    Offre all'utente opzioni da 1 a n, in base all'array
   *                    di stringhe di lunghezza n+1 inserito.
   * 
   * @param scannerNum  Scanner per lettura input utente.
   * @param menu        Stringa contenente il nome del menu in posizione zero,
   *                    e le opzioni a seguire. Deve contenere almeno 2 elementi,
   *                    ma sarebbe inutile avendone meno di 3.
   *  
   * @return            Opzione scelta dall'utente, un numero compreso tra 1 e
   *                    l'ampiezza della stringa in argomento meno uno.
   *                    Restituisce -1 in caso di errore.
   */
  public static int menuInt(Scanner scannerNum, String[] menu) {
    // --- Verifica argomenti
    if (scannerNum == null) {
      System.out.println("Errore: scanner nullo");
      return -1;
    }

    // Lunghezza array di stringhe in input
    // Corrisponde a numero di opzioni meno uno
    int size = menu.length;
    if (size < 2) {
      System.out.println("Errore: troppi pochi elementi del menu");
      return -1;
    }

    // --- Corpo funzione
    int scelta = -1;
    while (true) { // Loop continuo di selezione. uscita con selezione valida
      // Stampa testo menu
      System.out.println("   " + menu[0]);
      for (int i = 1; i < size; i++) {
        System.out.println(i + ". " + menu[i]);
      }
      // Accolta input utente
      System.out.print("Scelta: ");
      scelta = scannerNum.nextInt();

      // Verifica input
      if (1 <= scelta && scelta < size)
        return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a " + (size - 1));
    }
  }


  /**
   * @brief Input stringa da terminale con verifiche.
   * 
   * @param scannerString Scanner per lettura stringhe.
   * @param requestMsg    Messaggio di richiesta inserimento input.
   * @param wrongInputMsg Messaggio opzionale per input non valido.
   *                      "" per omettere.
   * @param acceptNull    True per accettare stringhe nulle.
   * @param acceptEmpty   True per accettare stringhe vuote.
   * @param acceptBlank   True per accettare stringhe di solo whitespace.
   * @return Stringa inserita dall'utente.
   *         In caso di errore, restituisce null.
   */
  public static String verifiedInputString(
      Scanner scannerString,
      String requestMsg,
      String wrongInputMsg,
      boolean acceptNull,
      boolean acceptEmpty,
      boolean acceptBlank) {
    // --- Verifica argomenti
    if (scannerString == null) {
      System.out.println("Errore selezione per caratteri: scanner nullo");
      return null;
    }
    if (requestMsg.isBlank()) {
      System.out.println("Errore selezione per caratteri: messaggio vuoto");
      return null;
    }

    // --- Corpo funzione
    while (true) { // Loop continua fino a input corretto utente.
      System.out.print(requestMsg);

      String bufferString = scannerString.nextLine();

      // Verifica input
      if ((!acceptNull && bufferString == null)
          || (!acceptEmpty && bufferString.isEmpty())
          || (!acceptBlank && bufferString.isBlank())) {
        if (!wrongInputMsg.isEmpty()) {
          System.out.println(wrongInputMsg);
        }
      } else {
        return bufferString; // <----------------------- USCITA LOOP E FUNZIONE
      }
    }
  }
}

class Officina {
  // Variabili d'istanza
  ArrayList<Auto> parcoAuto;

  // Costruttore
  Officina() {
    this.parcoAuto = new ArrayList<>();
  }

  // Aggiungere un’auto all’officina
  void addAuto(String targa, String modello) {
    // Targa univoca
    if (!checkLicensePlateAvailable(targa)) {
      System.out.println("Targa non disponibile.");
      return;
    }

    this.parcoAuto.add(new Auto(targa, modello));
  }

  // Controllare se targa non è già presente
  boolean checkLicensePlateAvailable(String targa) {
    // .size() lancia eccezione su ArrayList vuoto
    if (this.parcoAuto.size() == 0) {
      System.out.println("Nessuna auto.");
      return true;
    } 

    // Iterazione, controllo targhe sul parco auto
    for (Auto indexAuto : this.parcoAuto) {
      if (targa.equalsIgnoreCase(indexAuto.targa)) {
        return false;
      }
    }
    return true;
  }

  // Stampare elenco auto presenti
  void printAutos() {
    // .size() lancia eccezione su ArrayList vuoto
    if (this.parcoAuto.size() == 0) {
      System.out.println("Nessuna auto.");
      return;
    }

    // Stampa targa e modello di ogni Auto in parcoAuto
    for (Auto indexAuto : this.parcoAuto) {
      System.out.println(indexAuto.targa + " - " + indexAuto.modello);
    }
  }
}

class Auto {
  // Variabili d'istanza
  String targa;
  String modello;

  // Costruttore
  Auto(String targa, String modello) {
    this.targa = targa;
    this.modello = modello;
  }
}
