import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class Utility {

  // Funzione main qui solo per fare dei test
  public static void main(String[] args) {
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    int scelta = -1;

    // Valori in lettura
    String bufferString = "";
    int bufferInt = -1;
    double bufferDouble = -1.0;

    while (true) {

      scelta = menuInt(scannerNum, new String[]{"Test","Exit","selectionByChar","verifiedInputString","verifiedInputIntRange","verifiedInputDoubleRange"});

      if (scelta <= 1) {
        break;
      }

      switch (scelta) {
        case 2: // selectionByChar
          char sel = selectionByChar(scannerString, "qwerty", "uiop", new char[]{'a','b','c'});
          break;
        case 3: // verifiedInputString
          bufferString = verifiedInputString(scannerString, "insert string: ", "", false, false, false);
          break;
        case 4: // verifiedInputIntRange
          bufferInt = verifiedInputIntRange(0,Integer.MAX_VALUE, scannerNum, "insert int: ", "");
          break;
        case 5: // verifiedInputDoubleRange
          bufferDouble = verifiedInputDoubleRange(0.0, Double.MAX_VALUE, scannerNum, "insert double: ", "");
          break; 
        default: // Should be unreachable
          System.out.println("Error");
          break;
      }
    }

    scannerString.close();
    scannerNum.close();
  }

  /** @brief Menù di selezione a interi.
   *     <p>Offre all'utente opzioni da 1 a n, in base all'array di stringhe di lunghezza n+1
   *     inserito.
   * @param scannerNum Scanner per lettura input utente.
   * @param menu Stringa contenente il nome del menu in posizione zero, e le opzioni a seguire. Deve
   *     contenere almeno 2 elementi, ma sarebbe inutile avendone meno di 3.
   * @return Opzione scelta dall'utente: un numero compreso tra 1 e n dove n è l'ampiezza della stringa in
   *     argomento meno uno.
   * @throws RuntimeException per input inutilizzabile o eccezioni Scanner.
   */
  public static int menuInt(Scanner scannerNum, String[] menu) throws RuntimeException {
    // --- Verifica argomenti
    if (scannerNum == null) {
      return menuInt(menu);
    }
  
    // Lunghezza array di stringhe in input
    // Corrisponde a numero di opzioni meno uno
    int size = menu.length;

    // Verifica numero elementi del menu
    if (size < 2) {
      throw new RuntimeException("Elementi menu insufficienti");
    }

    // --- Corpo funzione

    // Scelta inserita dall'utente
    int scelta = -1;

    while (true) { // Loop continuo di selezione. uscita con selezione valida

      // Stampa testo menu
      System.out.println("   " + menu[0]);
      for (int i = 1; i < size; i++) {
        System.out.println(i + ". " + menu[i]);
      }

      // Accolta input utente
      System.out.print("Scelta: ");

      // Blocco try-catch per accogliere eccezioni Scanner
      try {
        scelta = scannerNum.nextInt();

        // next token does not match the Integer regular expression, or is out of range
      } catch (InputMismatchException e) {
        // Inserito un non numero o non intero
        System.out.println("Inserire un numero intero da 1 a " + (size - 1));
        // Sblocca scanner e riprova
        scannerNum.nextLine();
        continue;

        // scanner is closed
      } catch (IllegalStateException e) {
        System.out.println(e.getMessage());
        throw e;

        // input is exhausted
      } catch (NoSuchElementException e) {
        System.out.println(e.getMessage());
        scannerNum.close();
        throw e;
      }

      // Verifica input
      if (1 <= scelta && scelta < size) {
        return scelta; // <----------------------------- USCITA LOOP E FUNZIONE
      }

      // Inserito numero fuori range
      System.out.println("Inserire un numero intero da 1 a " + (size - 1));
    }
  }

  /** Menù di selezione a interi. 
   * Crea e distrugge il suo scanner. 
   * Polimorfo a @see #menuInt(Scanner,string[]).
   */
  public static int menuInt(String[] menu) throws RuntimeException {
    // --- Verifica argomenti
    
    // Lunghezza array di stringhe in input
    // Corrisponde a numero di opzioni meno uno
    int size = menu.length;

    // Verifica numero elementi del menu
    if (size < 2) {
      throw new RuntimeException("Elementi menu insufficienti");
    }

    // --- Corpo funzione

    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);

    // Scelta inserita dall'utente
    int scelta = -1;

    while (true) { // Loop continuo di selezione. uscita con selezione valida

      // Stampa testo menu
      System.out.println("   " + menu[0]);
      for (int i = 1; i < size; i++) {
        System.out.println(i + ". " + menu[i]);
      }

      // Accolta input utente
      System.out.print("Scelta: ");

      // Blocco try-catch per accogliere eccezioni Scanner
      try {
        scelta = scannerNum.nextInt();

        // next token does not match the Integer regular expression, or is out of range
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());

        // Sblocca scanner e riprova
        scannerNum.nextLine();
        continue;

        // scanner is closed
      } catch (IllegalStateException e) { 
        System.out.println(e.getMessage());
        throw e;

        // input is exhausted
      } catch (NoSuchElementException e) {
        System.out.println(e.getMessage());
        scannerNum.close();
        throw e;
      }

      // Verifica input
      if (1 <= scelta && scelta < size) {
        break; // <------------------------------------------------ USCITA LOOP
      }

      // Inserito numero fuori range
      System.out.println("Inserire un numero da 1 a " + (size - 1));
    }

    // Chiusura scanner
    scannerNum.close();
    return scelta;
  }

  /**@brief Richiesta di selezione per caratteri (case-insensitive).
   * @param scannerString Scanner per lettura input utente.
   * @param requestMsg Messaggio di richiesta input.
   * @param wrongInputMsg Messaggio opzionale di avvertimento per input errato. "" per omettere.
   * @param options Array di caratteri accettati per l'input. Non deve essere vuoto.
   * @return Carattere scelto dall'utente tra quelli disponibili.
   */
  public static char selectionByChar(
      Scanner scannerString, String requestMsg, String wrongInputMsg, char[] options) {
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
      for (int i = 0; i < (options.length - 1); i++) {
        System.out.print(options[i] + "/");
      }
      System.out.print(options[options.length - 1] + ") ");

      // Input utente
      String bufferString = "";
      // Blocco try-catch per accogliere eccezioni Scanner
      try {
        bufferString = scannerString.nextLine();

        // no line was found
      } catch (NoSuchElementException e) {
        System.out.println(e.getMessage());

        // Sblocca scanner e riprova
        scannerString.nextLine();
        continue;

        // scanner is closed
      } catch (IllegalStateException e) {
        System.out.println(e.getMessage());
        throw e;
      }

      

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
          return selection; // <---------------------- USCITA DA LOOP E FUNZIONE
        }
      }

      // Carattere inserito non è tra le opzioni
      if (!wrongInputMsg.isEmpty()) {
        System.out.println(wrongInputMsg);
      }
    }
  }

  /**@brief Input stringa da terminale con verifiche.
   * @param scannerString Scanner per lettura stringhe.
   * @param requestMsg Messaggio di richiesta inserimento input.
   * @param wrongInputMsg Messaggio opzionale per input non valido.
   * @param acceptNull True per accettare stringhe nulle.
   * @param acceptEmpty True per accettare stringhe vuote.
   * @param acceptBlank True per accettare stringhe di solo whitespace.
   * @return Stringa inserita dall'utente.
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

  public static int verifiedInputIntRange(
      int min, int max, Scanner scannerNum, String requestMsg, String wrongInputMsg) {
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
      int bufferNum;
      try {
        bufferNum = scannerNum.nextInt();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        scannerNum.nextLine(); // Sblocca scanner
        continue;
      }

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
      double min, double max, Scanner scannerNum, String requestMsg, String wrongInputMsg) {
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
