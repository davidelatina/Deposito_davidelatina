package EsercizioEreditarieta3;

import EsercizioEreditarieta3.StazioneSpaziale.StazioneSpaziale;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
Tema: Missione Spaziale
Classe Base: Astronauta
Ogni oggetto Astronauta dovrà avere:
nome (String)
email (String)
creditoOssigeno (float) – inizializzato in modo casuale ogni volta che l'utente accede (login)


Classe Contenitore: StazioneSpaziale
Questa classe rappresenta il contesto in cui operano gli astronauti. Contiene due array:
esperimenti – elenco dei nomi degli esperimenti scientifici proposti
valutazioni – valutazioni numeriche associate agli esperimenti (interi da 1 a 5)


Classi Derivate:
Scienziato – derivata da Astronauta, può aggiungere esperimenti alla stazione
Ispettore – derivata da Astronauta, può inserire valutazioni per gli esperimenti
Dopo 3 azioni svolte (aggiunta di esperimenti o valutazioni), le classi evolvono:
Scienziato diventa ScienziatoCapo, con la possibilità di stampare tutti gli esperimenti in una sola operazione
Ispettore diventa IspettoreEsperto, con la possibilità di stampare tutte le valutazioni


Menu principale:
L’applicazione mostrerà un menu ciclico che consente di:
1. Creare un nuovo astronauta (inserendo nome ed email)
2. Visualizzare i dati dell’astronauta
3. Ripetere il login (rigenera l'ossigeno in modo casuale)
4. Interagire con il profilo:
  Se Scienziato: aggiungere esperimenti
  Se Ispettore: inserire valutazioni
  Dopo 3 azioni, accedere alle funzioni avanzate
5. Uscire dal programma


Meccanismo di Identificazione
Per determinare se l’astronauta è un Scienziato o un Ispettore, è possibile utilizzare un input iniziale specifico (es. una domanda tipo: "Qual è il tuo pianeta
preferito?"). La risposta definisce il ruolo.
 */

public class MissioneSpaziale {
  public static void main(String[] args) {

    // Scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    // Inizializzazioni
    StazioneSpaziale mySt = new StazioneSpaziale();
    mySt.hire(false, "Pippo", "pippo@space.org");
    mySt.hire(true, "Topolino", "topolino@space.org");

    // Input utente
    int sceltaNum = -1;

    int bufferNum = -1;
    int bufferNum2 = -1;
    boolean ispettore = false;
    String bufferStr = "";
    String bufferStr2 = "";

    // Loop principale programma. Uscita selezionando 6
    while (true) {

      // Menu interattivo
      System.out.print("\n");
      sceltaNum =
          menuInt(
              scannerNum,
              new String[] {
                "Stazione Spaziale - " + mySt.getUserGreeting(),
                "Creare un nuovo astronauta (inserendo nome ed email)",
                "Visualizzare i dati dell'astronauta",
                mySt.getUserJob(),
                "Ripetere il login",
                "Visualizzare informazioni su un esperimento",
                "Uscire dal programma"
              });

      if (sceltaNum == 6) { // <-------------------------- USCITA DAL PROGRAMMA
        break;
      }

      switch (sceltaNum) {
        case 1: // Creare un nuovo astronauta
          while (true) {
            bufferStr =
                verifiedInputString(
                    scannerStr,
                    "Qual è il tuo pianeta preferito? (Giove: ispettore, Mercurio: scienziato) ",
                    "",
                    false,
                    false,
                    false);
            if (bufferStr.charAt(0) == 'g' || bufferStr.charAt(0) == 'm') {
              ispettore = bufferStr.charAt(0) == 'g';
              break;
            }
          }
          bufferStr = verifiedInputString(scannerStr, "Inserire nome: ", "", false, false, false);
          bufferStr2 = verifiedInputString(scannerStr, "Inserire email: ", "", false, false, false);
          mySt.hire(ispettore, bufferStr, bufferStr2);
          break;

        case 2: // Visualizzare i dati dell'astronauta
          mySt.printInfo();
          break;

        case 3: // Compito specifico dell'utente, secondo il suo lavoro / rango
          // Per poi chiamare la funzione overloaded work con gli argomenti corretti.

          // Ottieni rango utente
          bufferStr = mySt.getUserRank();

          // Scienziato: inserisci esperimenti
          if (bufferStr.equals("Scienziato")) {
            bufferStr =
                verifiedInputString(
                    scannerStr,
                    "Inserire nome esperimento: ",
                    "Nome invalido. ",
                    false,
                    false,
                    false);
            mySt.work(bufferStr);

            // Ispettore: valuta esperimenti
          } else if (bufferStr.equals("Ispettore")) {
            bufferNum =
                verifiedInputIntRange(
                    1,
                    Integer.MAX_VALUE,
                    scannerNum,
                    "Inserisci numero esperimento da valutare: ",
                    "");
            bufferNum2 =
                verifiedInputIntRange(
                    1, 5, scannerNum, "Inserisci voto (1-5): ", "Inserire numero tra 1 e 5.");
            mySt.work(bufferNum, bufferNum2);

            // Scienziato Esperto o Ispettore capo: stampa esperimenti con più o meno dettagli
          } else if (bufferStr.equals("Ispettore Capo") || bufferStr.equals("Scienziato Esperto")) {
            mySt.work();
          } else { // Dovrebbe essere irraggiungibile
            System.out.println("Errore selezione mansioni");
          }
          break;

        case 4: // Ripetere login
          for (int i = 0; i < 3; i++) {
            bufferStr = verifiedInputString(scannerStr, "Inserire nome: ", "", false, false, false);
            bufferStr2 =
                verifiedInputString(scannerStr, "Inserire email: ", "", false, false, false);
            if (mySt.login(bufferStr, bufferStr2)) {
              System.out.println("Login effettuato!");
              break;
            } else {
              System.out.println("Login invalido.");
            }
          }
          break;

        case 5: // informazioni singolo esperimento
          bufferNum =
              verifiedInputIntRange(
                  1, Integer.MAX_VALUE, scannerNum, "Inserire numero esperimento: ", "");
          System.out.println(mySt.getExperimentInfo(bufferNum));
          break;

        default: // Non dovrebbe essere raggiungibile
          System.out.println("Errore selezione menu");
          break;
      }
    }
  }

  /**
   * @brief Menù di selezione a interi.
   *     <p>Offre all'utente opzioni da 1 a n, in base all'array di stringhe di lunghezza n+1
   *     inserito.
   * @param scannerNum Scanner per lettura input utente.
   * @param menu Stringa contenente il nome del menu in posizione zero, e le opzioni a seguire. Deve
   *     contenere almeno 2 elementi, ma sarebbe inutile avendone meno di 3.
   * @return Opzione scelta dall'utente: un numero compreso tra 1 e n dove n è l'ampiezza della
   *     stringa in argomento meno uno.
   * @throws RuntimeException per input inutilizzabile o eccezioni Scanner.
   */
  public static int menuInt(Scanner scannerNum, String[] menu) throws RuntimeException {
    // --- Verifica argomenti
    if (scannerNum == null) {
      System.out.println("Scanner nullo");
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

  /**
   * Menù di selezione a interi. Crea e distrugge il suo scanner. Polimorfo a @see
   * #menuInt(Scanner,string[]).
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

  /**
   * @brief Input stringa da terminale con verifiche.
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
      int bufferNum = -1;
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
}
