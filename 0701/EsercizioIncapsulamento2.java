/*
Esercizio: Gestione Flotta di una Compagnia Aerea (Incapsulamento)
Obiettivo:
  Allenati con l’incapsulamento in Java usando almeno tre classi collegate tra loro nel dominio dell’aeronautica.
Traccia:
  Crea queste tre classi:
    Aereo
      Attributi privati:
        modello (String)
        numeroPosti (int)
        codice (String, identificativo dell’aereo)
      Getter e setter per tutti gli attributi (il setter di numeroPosti deve accettare solo valori positivi).
    Pilota
      Attributi privati:
        nome (String)
        numeroBrevetto (String)
        oreVolo (int)
      Getter e setter per tutti gli attributi (il setter di oreVolo deve accettare solo valori maggiori di zero).
    CompagniaAerea
      Attributi privati:
        nome (String)
        flotta (ArrayList di oggetti Aereo)
        piloti (ArrayList di oggetti Pilota)
      Metodo per aggiungere un aereo alla flotta.
      Metodo per aggiungere un pilota.
      Metodo per stampare tutte le informazioni sulla flotta e i piloti della compagnia.
Obblighi minimi:
  Crea almeno due aerei e due piloti e aggiungili alla compagnia aerea.
  Stampa a schermo le informazioni della compagnia, mostrando dati di aerei e piloti.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento2 {
  public static void main(String[] args) {
    // Creazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // Creazione oggetto
    CompagniaAerea myCA = new CompagniaAerea("myCompagniaAerea");

    // Aggiunta di alcuni dati
    myCA.addAereo(new Aereo("Boeing", 300, "A001"));
    myCA.addAereo(new Aereo("Airbus", 250, "A002"));

    myCA.addPilota(new Pilota("Pippo", "pip001", 100));
    myCA.addPilota(new Pilota("Paperino", "pap313", 1));

    // buffer inserimento dati utente
    String bufferString1 = "";
    String bufferString2 = "";
    int bufferInt = -1;

    // Loop principale programma
    while (true) {
      // Mostra menu
      String[] menu = {
        "Gestione Compagnia Aerea", "Aggiungi aereo", "Aggiungi pilota", "Stampa info", "Esci"
      };
      int scelta = menuInt(scannerNum, menu);

      if (scelta == menu.length - 1) break; // <--------- USCITA LOOP E PROGRAMMA

      switch (scelta) {
        case 1: // Aggiungi aereo
          // modello
          bufferString1 =
              verifiedInputString(scannerString, "Inserire modello: ", "", false, false, false);
          // Numero posti
          bufferInt =
              verifiedInputIntRange(
                  Integer.MIN_VALUE, Integer.MAX_VALUE, scannerNum, "Inserire numero posti: ", "");
          // Codice
          bufferString2 =
              verifiedInputString(
                  scannerString, "Inserire codice alfanumerico: ", "", false, false, false);
          // Tentativo di inserimento
          myCA.addAereo(new Aereo(bufferString1, bufferInt, bufferString2));
          break;

        case 2: // Aggiungi pilota
          // Nome
          bufferString1 =
              verifiedInputString(scannerString, "Inserire nome pilota: ", "", false, false, false);
          // Numero brevetto
          bufferString2 =
              verifiedInputString(
                  scannerString, "Inserire numero brevetto: ", "", false, false, false);
          // Ore di volo
          bufferInt =
              verifiedInputIntRange(
                  Integer.MIN_VALUE, Integer.MAX_VALUE, scannerNum, "Inserire ore di volo: ", "");
          // Tentativo di inserimento
          myCA.addPilota(new Pilota(bufferString1, bufferString2, bufferInt));

        case 3: // Stampa info
          myCA.print();
          break;
        default: // Non dovrebbe essere raggiungibile
          System.out.println("Errore selezione funzionalità");
          break;
      }
      System.out.println(""); // Per andare a capo
    }

    // Stampa finale
    myCA.print();

    // Chiusura scanner
    scannerNum.close();
    scannerString.close();
  }

  /**
   * @brief Menu di selezione a interi.
   *     <p>Offre all'utente opzioni da 1 a n, in base all'array di stringhe di lunghezza n+1
   *     inserito.
   * @param scannerNum Scanner per lettura input utente.
   * @param menu Stringa contenente il nome del menu in posizione zero, e le opzioni a seguire. Deve
   *     contenere almeno 2 elementi, ma sarebbe inutile avendone meno di 3.
   * @return Opzione scelta dall'utente, un numero compreso tra 1 e l'ampiezza della stringa in
   *     argomento meno uno. Restituisce -1 in caso di errore.
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
      if (1 <= scelta && scelta < size) return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a " + (size - 1));
    }
  }

  /**
   * @brief Input stringa da terminale con verifiche.
   * @param scannerString Scanner per lettura stringhe.
   * @param requestMsg Messaggio di richiesta inserimento input.
   * @param wrongInputMsg Messaggio opzionale per input non valido. "" per omettere.
   * @param acceptNull True per accettare stringhe nulle.
   * @param acceptEmpty True per accettare stringhe vuote.
   * @param acceptBlank True per accettare stringhe di solo whitespace.
   * @return Stringa inserita dall'utente. In caso di errore, restituisce null.
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
}

class CompagniaAerea {
  // Variabili d'istanza
  private String nome;
  private ArrayList<Aereo> flotta;
  private ArrayList<Pilota> piloti;

  // Costruttore
  CompagniaAerea(String nome) {
    this.nome = nome;
    this.flotta = new ArrayList<>();
    this.piloti = new ArrayList<>();
  }

  // Aggiungi aereo alla flotta
  void addAereo(Aereo myAereo) {
    if (myAereo.getNumeroPosti() <= 0) {
      System.out.println("Numero posti invalido");
      return;
    }
    this.flotta.add(myAereo);
  }

  // Aggiungi pilota
  void addPilota(Pilota myPilota) {
    if (myPilota.getOreVolo() <= 0) {
      System.out.println("Numero posti invalido");
      return;
    }
    this.piloti.add(myPilota);
  }

  // Stampa informazioni

  // Info flotta
  void printFlotta() {
    System.out.println("Flotta " + this.nome + ":");
    for (Aereo aereo : flotta) {
      aereo.print();
    }
  }

  // Info piloti
  void printPiloti() {
    System.out.println("Piloti " + this.nome + ":");
    for (Pilota pilota : piloti) {
      pilota.print();
    }
  }

  // Stampa tutto
  void print() {
    printFlotta();
    printPiloti();
  }
}

class Pilota {
  // Variabili d'istanza
  private String nome;
  private String numeroBrevetto;
  private int oreVolo;

  // Costruttore
  Pilota(String nome, String numeroBrevetto, int oreVolo) {
    this.nome = nome;
    this.numeroBrevetto = numeroBrevetto;
    this.oreVolo = oreVolo;
  }

  // Getters e setters
  public String getNome() {
    return nome;
  }

  public String getNumeroBrevetto() {
    return numeroBrevetto;
  }

  public int getOreVolo() {
    return oreVolo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setNumeroBrevetto(String numeroBrevetto) {
    this.numeroBrevetto = numeroBrevetto;
  }

  public void setOreVolo(int oreVolo) {
    if (oreVolo <= 0) {
      System.out.println("Errore: inserire numero maggiore di zero.");
      return;
    }
    this.oreVolo = oreVolo;
  }

  // Stampa informazioni
  void print() {
    System.out.println(
        this.nome
            + " - "
            + this.numeroBrevetto
            + " - "
            + this.oreVolo
            + (this.oreVolo == 1 ? " ora" : " ore")
            + " di volo");
  }
}

class Aereo {
  // Variabili d'istanza
  private String modello;
  private int numeroPosti;
  private String codice;

  // Costruttore
  Aereo(String modello, int numeroPosti, String codice) {
    this.modello = modello;
    this.numeroPosti = numeroPosti;
    this.codice = codice;
  }

  // Getters e setters
  public String getModello() {
    return modello;
  }

  public String getCodice() {
    return codice;
  }

  public int getNumeroPosti() {
    return numeroPosti;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public void setModello(String modello) {
    this.modello = modello;
  }

  public void setNumeroPosti(int numeroPosti) {
    if (numeroPosti <= 0) {
      System.out.println("Inserire numero posti valido.");
      return;
    }
    this.numeroPosti = numeroPosti;
  }

  // Stampa informazioni
  void print() {
    System.out.println(this.codice + " - " + this.modello + " - " + this.numeroPosti + " posti");
  }
}
