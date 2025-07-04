/*
Scrivi un programma Java che chiede all'utente di inserire un numero tra 1 e 3 e in base tramite uno switch e una condizione a tua scelta all'inserimento reale crea una di 3 classi figlie di Cadetto
In base alla classe reale creata stampa un messaggio diverso tramite un metodo polimorfico  .
Fai in modo che ogni classe abbia un suo parametro unico e uno in comune col padre ( Nome )
 */

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Esercizio3 {

  public static void main(String[] args) {
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);


    String nome = "";
    String risposta = "";



    
    System.out.println("Scegli un numero tra 1 e 3");
    int scelta = menuInt(scannerNum, new String[] {"Scegli un numero tra 1 e 3","EredeA","EredeB","EredeC"});

    
    //System.out.println("Inserire nome: ");
    nome = verifiedInputString(scannerStr, "Inserire nome ", "", false, false, false);


    switch (scelta) {
      case 1:
        System.out.println("Qual è il colore preferito di " + nome + "?");
        risposta = verifiedInputString(scannerStr, "", "", false, false, false);
        EredeA eredeA = new EredeA(nome, risposta);
        System.out.println(eredeA.info());
        break;

      case 2:
        System.out.println("Qual è il numero preferito di " + nome + "?");
        risposta = verifiedInputString(scannerStr, "", "", false,  false, false);
        EredeB eredeB = new EredeB(nome, risposta);
        System.out.println(eredeB.info());
        break;

      case 3:
        System.out.println("Qual è l'animale preferito di " + nome + "?");
        risposta = verifiedInputString(scannerStr, "", "", false,  false, false);
        EredeC eredeC = new EredeC(nome, risposta);
        System.out.println(eredeC.info());
        break;
    
      default:
        break;
    }
  
    



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

class EredeA extends Cadetto {
  EredeA(String nome, String colore) {
    super(nome);
    this.colore = colore;
  }

  String colore = "Rosso";

  @Override
  String info() {
    return "EredeA " + this.nome + ". colore preferito: " + colore;
  }
}
class EredeB extends Cadetto {
  EredeB(String nome, String numero) {
    super(nome);
    this.numero = numero;
  }

  String numero = "Sette";

  @Override
  String info() {
    return "EredeB" + this.nome + ". numero preferito: " + numero;
  }
}
class EredeC extends Cadetto {
  EredeC(String nome, String animale) {
    super(nome);
    this.animale = animale;

  }

  String animale = "Gatto";

  @Override
  String info() {
    return "EredeC" + this.nome + ". animale preferito: " + animale;
  }
}

class Cadetto {
  String nome;

  Cadetto(String nome) {
    this.nome=nome;
  }

  String info() {
    return "Classe padre";
  }
}
