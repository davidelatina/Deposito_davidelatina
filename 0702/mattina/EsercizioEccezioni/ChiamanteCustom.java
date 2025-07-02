package mattina.EsercizioEccezioni;

import java.util.Scanner;

public class ChiamanteCustom {
  public static void main(String[] args) {
    Scanner scannerNum = new Scanner(System.in);


    while (true) {

      int sceltaUtente = 
          menuInt(scannerNum, new String[]{"Procedere con la divisione?", "Si", "No"});

      if (sceltaUtente == 2) break;

      int a = verifiedInputIntRange(Integer.MIN_VALUE, Integer.MAX_VALUE, scannerNum, "Inserire il dividendo: ", "");

      try {
        Controller.checkPositive(a);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        continue;
      }

      int b = verifiedInputIntRange(Integer.MIN_VALUE, Integer.MAX_VALUE, scannerNum, "Inserire il divisore: ",
          "");
      
      try {
        Controller.checkNotZero(b);
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        continue;
      }

      System.out.println("a / b = " + a/b);

      

    }
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
      try {
        scelta = scannerNum.nextInt();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        scannerNum.nextLine(); // Sblocca scanner
        continue;
      }
      
      // Verifica input
      if (1 <= scelta && scelta < size) return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a " + (size - 1));
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
