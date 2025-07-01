import java.util.Scanner;

public class Utility {



  /**@brief             Menu di selezione a interi.
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
      for(int i = 1; i < size; i++) {
        System.out.println(i + ". " + menu[i]);
      }
      // Accolta input utente
      System.out.print("Scelta: ");
      scelta = scannerNum.nextInt();

      // Verifica input
      if (1 <= scelta && scelta < size)
        return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a " + (size-1));
    }
  }

  /**@brief                Richiesta di selezione per caratteri (case-insensitive).
   * 
   * @param scannerString  Scanner per lettura input utente.
   * @param requestMsg     Messaggio di richiesta input.
   * @param wrongInputMsg  Messaggio opzionale di avvertimento per input errato.
   *                       "" per omettere.
   * @param options        Array di caratteri accettati per l'input.
   *                       Non deve essere vuoto.
   * 
   * @return               Carattere scelto dall'utente.
   *                       In caso di errore, restituisce carattere nullo ('\0').
   */
  public static char selectionByChar(
      Scanner scannerString,
      String requestMsg, 
      String wrongInputMsg, 
      char[] options) {
    // --- Verifica argomenti
    if (scannerString == null) {
      System.out.println("Errore selezione per caratteri: scanner nullo");
      return '\0';
    }
    if (requestMsg.isBlank()) {
      System.out.println("Errore selezione per caratteri: messaggio vuoto");
      return '\0';
    }
    if (options.length == 0) {
      System.out.println("Errore selezione per caratteri: nessuna opzione");
      return '\0';
    }

    // --- Corpo funzione
    while (true) { // Loop continua fino a input corretto utente.

      // Richiesta all'utente in formato
      //    requestMsg (a/b/c/d) 
      System.out.print(requestMsg);

      System.out.print(" (");
      for (int i = 0; i < (options.length-1); i++) {
        System.out.print(options[i] + "/");
      }
      System.out.print(options[options.length-1] + ") ");
      
      // Input utente
      String bufferString = scannerString.nextLine();

      bufferString.trim();
      // Una stringa vuota porta .charAt(0) a lanciare un'eccezione
      if (bufferString.isEmpty()) {
        if (!wrongInputMsg.isEmpty()) {
          System.out.println(wrongInputMsg);
        }
        continue;
      }

      // Stringa non vuota da validare. Ignorando maiuscole/minuscole
      bufferString.toLowerCase();
      
      char selection = bufferString.charAt(0);
      for (int i = 0; i < options.length; i++) {
        if (selection == options[i]) {
          return selection; // <--------------------- USCITA DA LOOP E FUNZIONE
        }
      }
      
      // Carattere inserito non è tra le opzioni
      if (!wrongInputMsg.isEmpty()) {
        System.out.println(wrongInputMsg);
      }
    }
  }

  /**@brief                Input stringa da terminale con verifiche.
   * 
   * @param scannerString  Scanner per lettura stringhe.
   * @param requestMsg     Messaggio di richiesta inserimento input.
   * @param wrongInputMsg  Messaggio opzionale per input non valido. 
   *                       "" per omettere.
   * @param acceptNull     True per accettare stringhe nulle.
   * @param acceptEmpty    True per accettare stringhe vuote.
   * @param acceptBlank    True per accettare stringhe di solo whitespace.
   * @return               Stringa inserita dall'utente.
   *                       In caso di errore, restituisce null.
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
      if (   (!acceptNull && bufferString == null)
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

  public static int verifiedInputIntRange(
      int min,
      int max,
      Scanner scannerNum,
      String requestMsg,
      String wrongInputMsg) {
    // --- Verifica argomenti
    if (scannerNum == null) {
      System.out.println("Errore selezione intero: scanner nullo");
      return -1;
    }
    if (requestMsg.isBlank()) {
      System.out.println("Errore selezione intero: messaggio vuoto");
      return -1;
    }

    // --- Corpo funzione
    while (true) { // Loop continua fino a input corretto utente.
      System.out.print(requestMsg);

      int bufferNum = scannerNum.nextInt();

      // Verifica input
      if (min <= bufferNum && bufferNum <= max) {
        return bufferNum; // <-------------------------- USCITA LOOP E FUNZIONE
      } else {
        if (!wrongInputMsg.isEmpty()) {
          System.out.println(wrongInputMsg);
        }
      }
    } 
  }

  public static double verifiedInputDoubleRange(
      double min,
      double max,
      Scanner scannerNum,
      String requestMsg,
      String wrongInputMsg) {
    // --- Verifica argomenti
    if (scannerNum == null) {
      System.out.println("Errore selezione double: scanner nullo");
      return -1;
    }
    if (requestMsg.isBlank()) {
      System.out.println("Errore selezione double: messaggio vuoto");
      return -1;
    }

    // --- Corpo funzione
    while (true) { // Loop continua fino a input corretto utente.
      System.out.print(requestMsg);

      double bufferNum = scannerNum.nextDouble();

      // Verifica input
      if (min <= bufferNum && bufferNum <= max) {
        return bufferNum; // <-------------------------- USCITA LOOP E FUNZIONE
      } else {
        if (!wrongInputMsg.isEmpty()) {
          System.out.println(wrongInputMsg);
        }
      }
    }
  }




}
