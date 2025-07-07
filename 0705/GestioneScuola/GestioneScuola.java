/*
Titolo: Gestione di una Scuola – Esercizio OOP completo

Obiettivo:
  Progettare un sistema che rappresenti una scuola con più tipologie di persone (studenti e docenti), applicando tutte le regole dell’OOP:
  Incapsulamento: dati privati con metodi getter e setter
  Ereditarietà: classi che estendono una classe base comune
  Polimorfismo: metodo sovrascritto chiamato su riferimenti generici
  Astrazione: uso di classe astratta e interfaccia

Traccia:
  Classe Astratta Persona
  Attributi privati: nome (String), età (int)
  Costruttore con parametri
  Metodi getter/setter
  Metodo astratto descriviRuolo()
  Interfaccia Registrabile
  Metodo: registrazione() che stampa la modalità di registrazione della persona

  Classe Studente (extends Persona, implements Registrabile)

    Attributo: classeFrequentata (String)
    Override di descriviRuolo() che stampa “Sono uno studente della classe …”
    Implementazione di registrazione() che stampa “Registrazione tramite modulo online”

  Classe Docente (extends Persona, implements Registrabile)
    Attributo: materia (String)
    Override di descriviRuolo() che stampa “Sono un docente di …”
    Implementazione di registrazione() che stampa “Registrazione tramite segreteria didattica”

  Classe Principale GestioneScuola
  Istanzia una lista di tipo Persona con oggetti Studente e Docente
  Usa un ciclo per chiamare descriviRuolo() e registrazione() su ogni elemento della lista


Requisiti Obbligatori:
  I campi devono essere privati → incapsulamento
  L’interfaccia e la classe astratta devono essere usate → astrazione
  Le classi concrete devono derivare da una classe base → ereditarietà
  I metodi devono essere richiamati da riferimenti generici → polimorfismo

*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

abstract class Persona {
  private String nome;
  private int eta;

  public Persona(String nome, int eta) {
    this.nome = nome;
    this.eta = eta;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getEta() {
    return eta;
  }

  public void setEta(int eta) {
    this.eta = eta;
  }

  abstract void descriviRuolo();

  abstract void registrazione();
}

interface Registrabile {
  void descriviRuolo();

  void registrazione();
}

class Studente extends Persona implements Registrabile {

  private String classeFrequentata;

  public String getClasseFrequentata() {
    return classeFrequentata;
  }

  public void setClasseFrequentata(String classeFrequentata) {
    this.classeFrequentata = classeFrequentata;
  }

  public Studente(String nome, int eta, String classeFrequentata) {
    super(nome, eta);
    this.classeFrequentata = classeFrequentata;
  }

  public void registrazione() {
    System.out.println("Registrazione tramite modulo online");
  }

  public void descriviRuolo() {
    System.out.println("Sono uno studente della classe di " + this.getClasseFrequentata());
  }
}

class Docente extends Persona implements Registrabile {

  private String materia;

  public String getMateria() {
    return materia;
  }

  public void setMateria(String materia) {
    this.materia = materia;
  }

  public Docente(String nome, int eta, String materia) {
    super(nome, eta);
    this.materia = materia;
  }

  public void registrazione() {
    System.out.println("Registrazione tramite segreteria didattica");
  }

  public void descriviRuolo() {
    System.out.println("Sono un docente di " + this.getMateria());
  }
}

public class GestioneScuola {
  public static void main(String[] args) {

    // dichiarazione scuola, alunni e docenti standard
    Scuola myScuola = new Scuola("Istituto Carlo Pinneo");
    myScuola.addStudente(new Studente("Qui", 14, "Storia"));
    myScuola.addStudente(new Studente("Quo", 14, "Economia"));
    myScuola.addStudente(new Studente("Qua", 14, "Scienze"));

    myScuola.addDocente(new Docente("Paperoga", 34, "Storia"));
    myScuola.addDocente(new Docente("de Paperoni", 65, "Economia"));
    myScuola.addDocente(new Docente("Archimede", 44, "Scienze"));

    myScuola.stampa();

    // Dichiara scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    int scelta = -1;

    ArrayList<String> menuDinamico = new ArrayList<>();
    menuDinamico.add("Gestione scuola");
    menuDinamico.add("Esci");
    menuDinamico.add("Aggiungi studente");
    menuDinamico.add("Aggiungi docente");
    menuDinamico.add("Stampa");
    // menuDinamico.add("Aggiungi opzione");

    // Valori in lettura
    String bufferNome = "";
    String bufferMateria = "";
    int bufferInt = -1;

    while (true) {

      scelta = dynamicMenu(scannerString, menuDinamico, false);

      if (scelta <= 1) {
        break;
      }

      switch (scelta) {

        case 2: // Aggiungi studente:
          bufferNome = verifiedInputString(scannerString, "Inserire nome studente: ", "", false, false, false);

          bufferInt = verifiedInputIntRange(0, Integer.MAX_VALUE, scannerNum, "Inserire età: ", "Inserire valore positivo.");

          bufferMateria = verifiedInputString(scannerString, "Inserire materia: ", "", false, false, false);


          myScuola.addStudente(new Studente(bufferNome, bufferInt, bufferMateria));
          break;

        case 3: // Aggiungi docente
          bufferNome = verifiedInputString(scannerString, "Inserire nome docente: ",  "", false, false, false);

          bufferInt = verifiedInputIntRange(18, Integer.MAX_VALUE, scannerNum,   "Inserire età: ",
              "Deve avere almeno 18 anni per insegnare.");

          bufferMateria = verifiedInputString(scannerString, "Inserire materia: ", "", false, false, false);
          myScuola.addDocente(new Docente(bufferNome, bufferInt, bufferMateria));
         break;

        case 4: // Stampa
          myScuola.stampa();
          break;

        default: // Should be unreachable
          System.out.println("Error");
          break;
      }
    }


    scannerString.close();
    scannerNum.close();
  }

  /**
   * @brief Menù dinamico di selezione a interi.
   *        <p>
   *        Offre all'utente opzioni da 1 a n (o da 0 a n-1), in base all'array di
   *        stringhe di lunghezza n+1 inserito.
   * @param scanNum       oggetto Scanner adibito a leggere numeri
   * @param menu          ArrayList di stringhe contenente il nome del menu in
   *                      posizione zero, e le opzioni a seguire.
   * @param startFromZero Indica alla funzione se il menu debba partire da zero.
   * @return Opzione scelta dall'utente: un numero compreso tra 1 e n dove n è
   *         l'ampiezza della stringa in argomento meno uno, OPPURE un numero
   *         compreso tra 0 e n-1 se @see startFromZero è impostato su true.
   * @throws RuntimeException per eccezioni Scanner.
   */
  public static int dynamicMenu(Scanner scanNum, ArrayList<String> menu, boolean startFromZero)
      throws RuntimeException {

    // --- Verifica argomenti

    // Lunghezza array di stringhe in input
    // Corrisponde a numero di opzioni meno uno
    int size = menu.size();

    // Verifica numero elementi del menu
    if (size < 2) {
      throw new RuntimeException("Elementi menu insufficienti");
    }

    // Scanner scanNum = new Scanner(System.in);

    // --- Corpo funzione

    // Scelta inserita dall'utente
    int scelta = -1;

    while (true) { // Loop continuo di selezione. uscita con selezione valida

      // Stampa testo menu
      System.out.println("   " + menu.get(0));
      for (int i = 1; i < size; i++) {

        // Stampa numero menu
        System.out.print((startFromZero ? i - 1 : i));

        // Resto della riga, con nome dell'opzione
        System.out.println(". " + menu.get(i));
      }

      // Accolta input utente
      System.out.print("Scelta: ");

      // Blocco try-catch per accogliere eccezioni Scanner
      try {
        scelta = scanNum.nextInt();

        // next token does not match the Integer regular expression, or is out of range
      } catch (InputMismatchException e) {

        // Inserito un non numero o non intero
        System.out.println("Inserire un numero intero da " +
            (startFromZero ? "0" : "1") + " a " +
            (startFromZero ? (size - 2) : (size - 1)));

        // Sblocca scanner e riprova
        scanNum.nextLine();
        continue;

        // scanner is closed
      } catch (IllegalStateException e) {
        System.out.println(e.getMessage());
        throw e;

        // input is exhausted
      } catch (NoSuchElementException e) {
        System.out.println(e.getMessage());
        scanNum.close();
        throw e;
      }

      // Verifica input
      if (1 <= scelta && scelta < size) {
        return scelta; // <----------------------------- USCITA LOOP E FUNZIONE
      }

      // Inserito numero fuori range
      System.out.println("Inserire un numero intero da " +
          (startFromZero ? "0" : "1") + " a " +
          (startFromZero ? (size - 2) : (size - 1)));
    }
  }
  
  /**
   * @brief Input stringa da terminale con verifiche.
   * @param scannerString Scanner per lettura stringhe.
   * @param requestMsg    Messaggio di richiesta inserimento input.
   * @param wrongInputMsg Messaggio opzionale per input non valido.
   * @param acceptNull    True per accettare stringhe nulle.
   * @param acceptEmpty   True per accettare stringhe vuote.
   * @param acceptBlank   True per accettare stringhe di solo whitespace.
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
}

class Scuola {
  // Classe Principale GestioneScuola
  // Istanzia una lista di tipo Persona con oggetti Studente e Docente
  // Usa un ciclo per chiamare descriviRuolo() e registrazione() su ogni elemento
  // della lista

  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  ArrayList<Persona> persone;

  Scuola(String nome) {
    this.nome = nome;
    this.persone = new ArrayList<>();
  }

  public void addStudente(Studente s) {
    persone.add(s);
  }

  public void addDocente(Docente d) {
    persone.add(d);
  }

  public void stampa() {

    /*for (Registrabile r : persone) {
      
    } */

    for (Persona persona : persone) {
      persona.descriviRuolo();
      persona.registrazione();
      System.out.println();
    }
  }
}
