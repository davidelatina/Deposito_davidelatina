/*
Incapsulamento con la Classe Studente 
Obiettivo:Comprendere e applicare il concetto di incapsulamento in Java tramite l’uso di attributi privati e metodi getter/setter.

Traccia: Crea una classe Studente con i seguenti attributi privati:
  nome(String)
  voto(int)
  id(int-statico-autoincrementante)
Implementa:
  Un costruttore per inizializzare nome e voto.
  Un metodo getter per leggere il nome.
  Un metodo getter per leggere il voto.
  Un metodo setter per modificare il voto,assicurandoti che il voto sia sempre compreso tra 0 e 10(se fuori intervallo,non modificare e stampa un messaggio di errore).
Nel main:
  Crea un oggetto Studente.
  Stampa nome e voto iniziale.
  Prova a cambiare il voto con valori validi e non validi,stampando il risultato ogni volta.
  Gestire la lista di studenti tramite un arraylist rendere possibile la ricerca di uno studente  tramite nome
*/

import java.util.Scanner;

public class EsercizioIncapsulamento {
  public static void main(String[] args) {
    // Creazione scanner
    Scanner scannerNum = new Scanner(System.in);

    // Creazione oggetto Studente
    Studente pippo = new Studente("Pippo", 7);

    // Scelta utente
    char scelta = 'n';

    // Stampa nome e voto iniziale
    System.out.println("Studente #" + pippo.getId() + ":\t" + pippo.getNome());
    System.out.println("Voto:\t" + pippo.getVoto());


    // Cambiamento voto
    char[] opzioni = {'y','n'};
    scelta = selectionByChar(
      scannerNum, 
      "Inserire un voto diverso?", 
      "Inserire un carattere valido", 
      opzioni);

    // Cambiamento voto confermato
    if (scelta == 'y') {
      System.out.println("Inserire nuovo voto: ");
      pippo.setVoto(scannerNum.nextInt());
    }
    
    // Stampa nome e voto finale
    System.out.println("Studente #" + pippo.getId() + ":\t" + pippo.getNome());
    System.out.println("Voto:\t" + pippo.getVoto());

    // Rimozione scanner
    scannerNum.close();
  }

  /**
   * @brief Richiesta di selezione per caratteri (case-insensitive).
   * 
   * @param scannerString Scanner per lettura input utente.
   * @param requestMsg    Messaggio di richiesta input.
   * @param wrongInputMsg Messaggio opzionale di avvertimento per input errato.
   *                      "" per omettere.
   * @param options       Array di caratteri accettati per l'input.
   *                      Non deve essere vuoto.
   * 
   * @return Carattere scelto dall'utente.
   *         In caso di errore, restituisce carattere nullo ('\0').
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


class Studente {
  // Variabili statiche
  private static int totale = 0;

  // Variabili di istanza
  private String nome;
  private int voto;
  private int id;

  // Costruttore
  Studente(String nome, int voto) {
    this.nome = nome;
    this.voto = voto;
    this.id = totale+1; // Cominciando a contare da 1
    totale++;
  }

  String getNome() {
    return this.nome;
  }

  int getVoto() {
    return this.voto;
  }

  void setVoto(int votoNew) {
    if (votoNew < 0 || 10 < votoNew) {
      System.out.println("Voto invalido. Nessuna modifica effettuata.");
      return;
    }
    this.voto = votoNew;
  }

  int getId() {
    return this.id;
  }
}
