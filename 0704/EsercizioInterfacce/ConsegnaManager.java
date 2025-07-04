/*
Obiettivo:

Comprendere la differenza tra classe astratta e interfaccia, il loro utilizzo e come si applica l'astrazione per modellare comportamenti comuni e specializzati tra classi diverse.

Traccia:


Progetta un sistema Java che simuli un servizio di consegna (delivery) in cui esistono diversi tipi di mezzi che effettuano le consegne in modo differente.

1. Classe Astratta VeicoloConsegna

Attributi:

targa (String)

caricoMassimo (float)

Metodo astratto:

consegnaPacco(String destinazione)

Metodi concreti:

stampaInfo(): stampa i dati del veicolo

2. Interfaccia Tracciabile

Metodo:

tracciaConsegna(String codiceTracking): simula la tracciabilità della spedizione

3. Classi Concrete

Crea almeno due classi che estendono VeicoloConsegna e implementano Tracciabile:

Furgone: stampa che sta consegnando via strada con targa e destinazione

Drone: stampa che sta volando verso la destinazione e fornisce un tracking automatico

4. Classe Principale ConsegnaManager

Crea una lista o array di oggetti VeicoloConsegna

Permetti all’utente di aggiungere un veicolo (furgone o drone), impostare i dati, e chiamare i metodi consegnaPacco() e tracciaConsegna()

Dimostra il concetto di polimorfismo e astrazione (lavorando con riferimenti astratti)


Requisiti Tecnici:

Usare almeno una classe astratta con metodo astratto

Usare un’interfaccia implementata da più classi


Estensione Facoltativa:

Aggiungi un controllo del carico: se la consegna supera il caricoMassimo, il metodo consegnaPacco() stampa un errore.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class ConsegnaManager {
  public static void main(String[] args) {

    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    ArrayList<VeicoloConsegna> flotta = new ArrayList<>();

    //Permetti all’utente di aggiungere un veicolo (furgone o drone), impostare i dati, e chiamare i metodi consegnaPacco() e tracciaConsegna()

    flotta.add(new Furgone("001", 500.0f));
    flotta.add(new Drone("001", 10.0f));

    String targa;
    String destinazione;
    float bufferFloat;


    // aggiungi veicolo, imposta dati
    int scelta = menuInt(scannerNum, new String[] { "Consegna con furgone o drone?", "Furgone", "Drone" });

    targa = verifiedInputString(scannerStr, "Inserisci targa: ", "bufferString", false, false, false);

    bufferFloat = (float) verifiedInputDoubleRange(0.0, 100000, scannerNum, "Inserire carico massimo: ", "");

    destinazione = verifiedInputString(scannerStr, "Consegnare dove? ", "", false, false, false);

    VeicoloConsegna veicolo;
    if (scelta == 1) {
      veicolo = new Furgone(targa, bufferFloat);
      veicolo.tracciaConsegna("bbbb");
    } else {
      veicolo = new Drone(targa, bufferFloat);
      veicolo.tracciaConsegna("aaaa");
    }
    flotta.add(veicolo);

    
    // consegna
    
    
    veicolo.consegnaPacco(destinazione);
    

/*
    while (true) {

      int scelta = menuInt(scannerNum, new String[]{"Consegne","Esci","Aggiungi drone","Aggiungi furgone","Spedizione furgone","Spedizione drone"});


      if (scelta == 1) {
        break;
      }

      switch (scelta) {
        case 2: //

          break;
        
        case 3: //

          break;

        case 4: //

          break;

        case 5: //

          break;

        case default: //

          break;




      }


    }*/
    
  }

  /**
   * @brief Menù di selezione a interi.
   *        <p>
   *        Offre all'utente opzioni da 1 a n, in base all'array di stringhe di
   *        lunghezza n+1
   *        inserito.
   * @param scannerNum Scanner per lettura input utente.
   * @param menu       Stringa contenente il nome del menu in posizione zero, e le
   *                   opzioni a seguire. Deve
   *                   contenere almeno 2 elementi, ma sarebbe inutile avendone
   *                   meno di 3.
   * @return Opzione scelta dall'utente: un numero compreso tra 1 e n dove n è
   *         l'ampiezza della
   *         stringa in argomento meno uno.
   * @throws RuntimeException per input inutilizzabile o eccezioni Scanner.
   */
  public static int menuInt(Scanner scannerNum, String[] menu) throws RuntimeException {
    // --- Verifica argomenti
    if (scannerNum == null) {
      //return menuInt(menu);
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

interface Tracciabile {

  abstract void tracciaConsegna(String codiceTracking);

}

abstract class VeicoloConsegna {

  String targa;

  float caricoMassimo;

  String tracking;

// Metodo astratto:
abstract void consegnaPacco(String destinazione);

// Metodi concreti:
// stampa i dati del veicolo
  void stampaInfo() {
    System.out.println("Veicolo " + " | targa: " +this.targa+ " | carico max: " + this.caricoMassimo);
  }

}


class Furgone extends VeicoloConsegna implements Tracciabile {

  Furgone(String targa, float caricoMassimo) {
    this.targa = targa;
    this.caricoMassimo = caricoMassimo;
  }

  // stampa che sta consegnando via strada con targa e destinazione
  public void tracciaConsegna(String codiceTracking) {
    if (codiceTracking == this.tracking) {
      System.out.println("Pacco in transito via strada");
    }
  }

  void consegnaPacco(String destinazione) {
    System.out.println("Il furgone targa " + targa + " sta consegnando via strada a " + destinazione);

    this.tracking = "bbbb";

    System.out.println("Codice tracking: " + tracking);
  }
  

} 

class Drone extends VeicoloConsegna implements Tracciabile {

  Drone(String targa, float caricoMassimo) {
    this.targa = targa;
    this.caricoMassimo = caricoMassimo;
  }

  // stampa che sta volando verso la destinazione e fornisce un tracking
  // automatico
  void consegnaPacco(String destinazione) {
    System.out.println("Il drone con id " + targa + " sta consegnando via strada a " + destinazione);

    this.tracking = "aaaa";

    System.out.println("Codice tracking: " + tracking);

  } 

  public void tracciaConsegna(String codiceTracking) {
    if (codiceTracking == this.tracking) {
      System.out.println("Pacco in transito via aria");
    }
  }
}
