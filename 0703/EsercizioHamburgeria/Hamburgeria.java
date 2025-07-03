package EsercizioHamburgeria;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/*
Titolo: Sistema di Ordine in un’Hamburgeria – Esercizio sul Polimorfismo


Obiettivo Didattico:
Comprendere e applicare il polimorfismo in Java simulando la preparazione di diversi tipi di hamburger. Lo studente dovrà
implementare una gerarchia di classi con comportamento polimorfico e usare l’overriding di metodi.

Traccia Esercizio:
Realizza un programma Java che simuli il comportamento di una cucina di hamburger in cui è possibile preparare vari
tipi di panino.

Crea una classe Hamburger con:
un attributo nome (String)
un metodo prepara() che stampa il procedimento di preparazione
un costruttore che imposta il nome
un metodo getNome() per restituire il nome del panino

Crea tre classi che estendono Hamburger:
Cheeseburger: stampa “Preparazione Cheeseburger: pane, carne, formaggio, ketchup”
VegBurger: stampa “Preparazione VegBurger: pane integrale, burger vegetale, insalata, pomodoro”
DoubleBacon: stampa “Preparazione DoubleBacon: pane, doppia carne, bacon, cheddar, maionese”

Nella classe principale (Hamburgeria) implementa:
un menu in loop che consente di creare un nuovo ordine
chiedere all’utente quale panino desidera (con Scanner)
creare l’oggetto corrispondente e salvarlo in una ArrayList<Hamburger>
iterare sulla lista e richiamare il metodo prepara() su ogni panino ordinato
 */

public class Hamburgeria {
  public static void main(String[] args) {
    // Scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);


    // Ordine da preparare
    ArrayList<Hamburger> ordine = new ArrayList<>();

    

    // Input utente
    int sceltaNum = -1;
    String bufferStr = "";
    
    // Loop principale programma, uscita scegliendo 1
    while (true) {
      sceltaNum = menuInt(scannerNum, new String[] {
          "Hamburgeria - Effettua Ordine - " + ordine.size() + " panini",
          "Completa ordine",
          "Hamburger",
          "Cheeseburger",
          "Vegburger",
          "DoubleBacon",
          "Hamburger Personalizzato" });
      if (sceltaNum == 1) { // <-------------------------- USCITA DAL PROGRAMMA
        break;
      }
      
      switch (sceltaNum) {
        
        case 2: 
          ordine.add(new Hamburger());
          break;

        case 3: 
          ordine.add(new Cheeseburger());
          break;

        case 4: 
          ordine.add(new VegBurger());
          break;

        case 5:
         ordine.add(new DoubleBacon());
         break;

        case 6: // Hamburger personalizzato

          // Ingredienti per hamburger personalizzato
          ArrayList<String> ingredienti = new ArrayList<>();

          while (true) { // Uscita scegliendo almeno un ingrediente e poi "esci"
            bufferStr = verifiedInputString(scannerStr, "Inserisci tutti gli ingredienti, \"fine\" per terminare. ", "Ingrediente non valido.", false, false, false);
            if (bufferStr.equalsIgnoreCase("fine")) {
              if (ingredienti.size() == 0) {
                System.out.println("Almeno un ingrediente!");
              } else { // <---------------------------------------- USCITA LOOP
                break;
              }
            }
            ingredienti.add(bufferStr);
          }
          ordine.add(new HamburgerPersonalizzato(ingredienti));
          break;

        default: // Non dovrebbe essere raggiungibile
          System.out.println("Errore selezione menu");
          break;
      }
    }

    
    System.out.println("Ordine in lavorazione: ");

    for (Hamburger h : ordine) {
      h.prepara();
    }

    System.out.println("Ordine completato.");


    scannerNum.close();
    scannerStr.close();
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

}



class HamburgerPersonalizzato extends Hamburger {
  ArrayList<String> ingredienti;

  HamburgerPersonalizzato(ArrayList<String> ingredienti) {
    this.ingredienti = ingredienti;
  }

  void prepara() {
    System.out.println("Preparazione " + this.toString() + ": ");
    for (String string : this.ingredienti) {
      System.out.print(string + ", ");
    }
    System.out.println("");
  }
  
  @Override
  public String toString() {
    return "Hamburger Personalizzato";
  }
}

class Cheeseburger extends Hamburger {
  Cheeseburger() {
    this.nome = "Cheeseburger";
  }

  void prepara() {
    System.out.println("Preparazione " + this.toString() + ": pane, carne, formaggio, ketchup");
  }
  
  @Override
  public String toString() {
    return "Cheeseburger";
  }
}


class DoubleBacon extends Hamburger {
  DoubleBacon() {
    this.nome = "DoubleBacon";
  }
  void prepara() {
    System.out.println("Preparazione " + this.toString() + ": pane, doppia carne, bacon, cheddar, maionese");
  }

  @Override
  public String toString() {
    return "DoubleBacon";
  }
}

class VegBurger extends Hamburger {

  VegBurger() {
    this.nome = "VegBurger";
  }
  void prepara() {
    System.out.println("Preparazione " + this.toString() + ": pane integrale, burger vegetale, insalata, pomodoro");
  }

  @Override
  public String toString() {
    return "VegBurger";
  }
}

class Hamburger {
  String nome;
  
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  Hamburger() {
    this.nome = "Hamburger Classico";
  }

  Hamburger(String nome) {
    this.nome = nome;
  }

  void prepara() {
    System.out.println("Preparazione " + this.toString() +  ": pane, carne");
  }


  

  @Override
  public String toString() {
    return "Hamburger";
  }
}
