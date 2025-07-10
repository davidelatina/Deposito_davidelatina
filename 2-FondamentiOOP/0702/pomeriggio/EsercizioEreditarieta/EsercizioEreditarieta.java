package pomeriggio.EsercizioEreditarieta;

import java.util.ArrayList;
import java.util.Scanner;
/*
Esercizio: Animali e Ereditarietà
Obiettivo:
  Comprendere il concetto di ereditarietà in Java tramite la creazione di una classe base e due sottoclassi.
Traccia:
  1. Crea una classe Animale con:
    Attributi: 
      nome (String), 
      età (int)
    Metodo: 
      faiVerso() che stampa “Verso generico…”

  2. Crea due sottoclassi che estendono Animale:
    Cane, con override di faiVerso() che stampa “Bau!”
    Gatto, con override di faiVerso() che stampa “Miao!”
  3. Nel main:
    Crea un array di Animale che contiene sia cani che gatti.
    Stampa nome, età e verso di ciascun animale nel ciclo.
    vai a creare una classe zoo con dentro almeno 3 tipi di animali divisi in liste diverse riempite dall’utente
 */


public class EsercizioEreditarieta {
  public static void main(String[] args) {
    // Scanner
    Scanner scannerNum = new Scanner (System.in);
    Scanner scannerString = new Scanner(System.in);

    char scelta = 'n';
    String bufferString = "";
    int bufferInt = -1;

    // Array animali fattoria
    Animale animaliFattoria[] = {
        new Animale("pinco", 2),
        new Animale("pallino", 3),
        new Cane("fido", 1),
        new Gatto("chicco", 4)};

    // Stampa animali fattoria
    System.out.println("Animali della fattoria:");
    for (Animale animale : animaliFattoria) {
      System.out.print(animale.nome + ", " + animale.eta + " anni.");
      animale.faiVerso();
    }

    // Animali zoo
    Zoo myZoo = new Zoo("myZoo");

    // Aggiunta sezioni
    myZoo.sezioni.add(new SezioneZoo("Canidi"));
    myZoo.sezioni.add(new SezioneZoo("Felini"));
    myZoo.sezioni.add(new SezioneZoo("Uccelli"));
    

    // Input utente animali
    for (SezioneZoo sezione : myZoo.sezioni) {
      while (true) {
        scelta = selectionByChar(scannerString, "Inserire " + sezione.nome + "?", "", new char[] { 's', 'n' });
        if (scelta == 'n')
          break;
        bufferString = verifiedInputString(scannerString, "Inserisci nome: ", "", false, false, false);
        bufferInt = verifiedInputIntRange(0, Integer.MAX_VALUE, scannerNum, "Inserisci età: ", "");
        sezione.animali.add(new Animale(bufferString, bufferInt));
      }
    }

    // Stampa finale animali
    System.out.println("Animali dello zoo:");
    for (SezioneZoo sezione : myZoo.sezioni) {
      for (Animale animale : sezione.animali) {
        System.out.print(animale.nome + ", " + animale.eta + " anni.");
        animale.faiVerso();
      }
    }

    
    
    






    scannerNum.close();
    scannerString.close();
  }

  /**
   * @brief Input stringa da terminale con verifiche.
   * @param scannerString Scanner per lettura stringhe.
   * @param requestMsg    Messaggio di richiesta inserimento input.
   * @param wrongInputMsg Messaggio opzionale per input non valido. "" per
   *                      omettere.
   * @param acceptNull    True per accettare stringhe nulle.
   * @param acceptEmpty   True per accettare stringhe vuote.
   * @param acceptBlank   True per accettare stringhe di solo whitespace.
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

  /**
   * @brief Richiesta di selezione per caratteri (case-insensitive).
   * @param scannerString Scanner per lettura input utente.
   * @param requestMsg    Messaggio di richiesta input.
   * @param wrongInputMsg Messaggio opzionale di avvertimento per input errato. ""
   *                      per omettere.
   * @param options       Array di caratteri accettati per l'input. Non deve
   *                      essere vuoto.
   * @return Carattere scelto dall'utente. In caso di errore, restituisce
   *         carattere nullo ('\0').
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
      // requestMsg (a/b/c/d)
      System.out.print(requestMsg);

      System.out.print(" (");
      for (int i = 0; i < (options.length - 1); i++) {
        System.out.print(options[i] + "/");
      }
      System.out.print(options[options.length - 1] + ") ");

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
}

class SezioneZoo {
  String nome;
  ArrayList<Animale> animali = new ArrayList<>();

  SezioneZoo(String nome) {
    this.nome = nome;
    this.animali = new ArrayList<>();
  }
}

class Zoo {
  String nome;
  ArrayList<SezioneZoo> sezioni = new ArrayList<>();

  Zoo(String nome) {
    this.nome = nome;
    this.sezioni = new ArrayList<>();
  }

}

class Animale {
  // Variabili d'istanza
  String nome;
  int eta;

  // Costruttori
  Animale() {
    this.nome = "Senza nome";
    this.eta = 0;
  }
  Animale(String nome) {
    this.nome = nome;
    this.eta = 0;
  }

  Animale(String nome, int eta) {
    this.nome = nome;
    this.eta = eta;
  }

  // Metodi
  void faiVerso() {
    System.out.println("Verso Generico");
  }
}

class Cane extends Animale {

  // Costruttori
  Cane() {
    super();
  }

  Cane(String nome) {
    super(nome);
  }

  Cane(String nome, int eta) {
    super(nome, eta);
  }

  // Metodi
  void faiVerso() {
    System.out.println("Bau Bau");
  }
}

class Gatto extends Animale {

  // Costruttori
  Gatto() {
    super();
  }

  Gatto(String nome) {
    super(nome);
  }

  Gatto(String nome, int eta) {
    super(nome, eta);
  }

  // Metodi
  void faiVerso() {
    System.out.println("Miao");
  }
}

class Papera extends Animale {

  // Costruttori
  Papera() {
    super();
  }

  Papera(String nome) {
    super(nome);
  }

  Papera(String nome, int eta) {
    super(nome, eta);
  }

  // Metodi
  void faiVerso() {
    System.out.println("Qua Qua");
  }
}