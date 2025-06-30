import java.util.Scanner;

public class Utility {
  /**@brief             Menu di selezione.
   *                    
   *                    Offre all'utente opzioni da 1 a n, in base all'array
   *                    di stringhe inserito.
   * 
   * @param scannerNum  Scanner per lettura input utente.
   * @param menu        Stringa contenente il nome del menu in posizione zero,
   *                    e le opzioni a seguire. Deve contenere almeno 2 elementi,
   *                    ma sarebbe inutile avendone meno di 3.
   * 
   * @return            Opzione scelta dall'utente, un numero compreso tra 1 e 
   *                    l'ampiezza della stringa in argomento.
   *                    Restituisce -1 in caso di errore.
   */
  static int menuInteri(Scanner scannerNum, String[] menu) {
    // Verifica argomenti
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

    // Corpo funzione
    int scelta = -1;
    while (true) { // Loop continuo di selezione. uscita con selezione valida
      // Stampa testo menu
      System.out.println("   " + menu[0]);
      for(int i = 1; i < size; i++) {
        System.out.println(i + ". " + menu[i]);
      }
      // Accolta input utente
      System.out.print("Scelta: ");
      scelta = scannerNum.nextInt();

      // Verifica input
      if (1 <= scelta && scelta < size)
        return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a " + (size-1));
    }
  }
}
