/*
Realizza una classe DatabaseManager che segua il pattern Singleton. La classe deve:


Avere un costruttore privato e un metodo statico getInstance() che restituisce
sempre la stessa istanza.

Simulare una connessione al database con un metodo connect() che:
Stampi un messaggio del tipo: "Connessione stabilita. Connessioni attive: X"
Incrementi un contatore interno ogni volta che viene chiamato.
Fornire un metodo getConnectionCount() che restituisca il numero totale di
connessioni effettuate.


Nel main:
Chiama DatabaseManager.getInstance() da più punti del programma simulando diverse
richieste di connessione.
Dimostra che l’oggetto utilizzato è sempre lo stesso.
Stampa il numero totale di connessioni con getConnectionCount().
*/

import java.util.Scanner;

public class EsDbManager {
  public static void main(String[] args) {
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    DatabaseManager_singleton db = DatabaseManager_singleton.getInstance();
    DatabaseManager_singleton db2 = DatabaseManager_singleton.getInstance();

    int scelta = -1;

    while (true) {

      // Menu
      System.out.println("");
      System.out.println("   Connessione DB");
      System.out.println("1. Esci");
      System.out.println("2. Effettua connessione");
      System.out.println("3. Reset connessione");
      System.out.println("4. Verifica continuità sessione");

      // Scelta utente
      scelta = scannerNum.nextInt();
      scannerNum.nextLine(); // Smaltire newline

      if (scelta <= 1) {
        break; // <-------------------------------------------USCITA PROGRAMMA
      }

      switch (scelta) {
        case 2: // Effettua connessione

          // Ottieni singleton
          db = DatabaseManager_singleton.getInstance();

          // Connessione db
          db.connect();

          break;

        case 3: // Reset connessione
          // Reset singleton
          DatabaseManager_singleton.resetInstance();
          break;

        case 4: // Verifica continuità sessione
          System.out.println("Prima connessione");

          // Ottieni singleton
          db = DatabaseManager_singleton.getInstance();

          // Connessione db
          db.connect();

          System.out.println("Seconda connessione");

          // Ottieni singleton
          db2 = DatabaseManager_singleton.getInstance();

          // Connessione db
          db2.connect();

          // Verifica che è la stessa istanza
          if (db == db2) {
            System.out.println("Conferma: db e db2 sono la stessa istanza.");
          } else {
            System.out.println("Errore: le istanze non coincidono.");
          }
          break;

        default: // Should be unreachable
          System.out.println("Error");
          break;
      }
    }

    // Chiusura scanners
    scannerString.close();
    scannerNum.close();
  }
}

class DatabaseManager_singleton {
  // Contatore numero totale connessioni
  int connectionCount = 0;
  int connectionId = -1;

  int getConnectionCount() {
    return this.connectionCount;
  }

  // Istanza privata statica della classe Singleton
  private static DatabaseManager_singleton instance;

  // Costruttore privato per impedire l'istanziazione diretta
  private DatabaseManager_singleton() {
    // Imposta connectionId casuale
    this.connectionId = 100000 + (int) (Math.random() * 100000);

  }

  // Metodo pubblico statico per ottenere l'unica istanza della classe
  public static DatabaseManager_singleton getInstance() {

    // Se l'istanza non esiste, viene creata
    if (instance == null) {
      instance = new DatabaseManager_singleton();
    }

    // Restituisce l'istanza esistente o appena creata
    return instance;
  }

  // Metodo per connettersi al DB fittizio
  public void connect() {

    this.connectionCount++;
    System.out.println("ID connessione: " + this.connectionId + ". Numero totale connessioni: " + this.connectionCount);
  }

  public static void resetInstance() {
    instance = null;
  }
}