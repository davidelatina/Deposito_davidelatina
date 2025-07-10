import java.util.Scanner;

public class EsercizioMetodi {
  /*
  Creare un metodo che accetti un
  numero intero e restituisca il suo
  fattoriale.
  Se il parametro passato è una stringa
  scrive “Inserisci un numero valido”
  (svolgere l’esercizio con
  l’overloading)
  */


  static int fattoriale(int numero) {
    // I fattoriali non sono definiti prima di 0
    if (numero < 0) { // errore
      System.out.println("Errore: inserire un numero >= 0");
      return -1;
    }  
    // fattoriale di 0 e 1 è 1
    if (numero <= 1) return 1;

    // calcolo fattoriale: n! = 1*2*3*....*(n-2)*(n-1)*n
    int risultato = 1;
    for (int i = 2; i <= numero; i++) {
      risultato *= i;
    }
    return risultato;
  }

  // Overloading con stringa, invia messaggio di errore
  static int fattoriale(String testo) {
    System.out.println("Inserisci un numero valido.");
    // extra: contare numero di char dentro stringa
    return testo.length();
  }

  public static void main(String[] args) {
    // dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // Input numero e stringa
    String inputStringa = "";
    int inputNumero = -1;

    while (true) {

      // Lettura scelta input utente
      String scelta;
      while (true) {
        System.out.print("Vuoi inserire una stringa o un numero? (s/n): ");
        scelta = scannerString.nextLine();

        // Una stringa vuota porta .charAt(0) a lanciare un'eccezione
        if (scelta.isEmpty()) continue;

        scelta.trim().toLowerCase();
        if (scelta.charAt(0) == 's' || scelta.charAt(0) == 'n')
          break;
      }

      // Inserimento da parte dell'utente
      System.out.print("Inserisci l'input: ");
      if (scelta.charAt(0) == 's') {
        inputStringa = scannerString.nextLine();
        System.out.println("lunghezza stringa: " + fattoriale(inputStringa));
      } else {
        inputNumero = scannerNum.nextInt();
        System.out.println(inputNumero + "! = " + fattoriale(inputNumero));
      }

      // Utente sceglie se continuare esecuzione
      System.out.print("Scrivi \"esci\" per terminare l'esecuzione, " +
        "o premi solo invio per continuare: ");
      scelta = scannerString.nextLine().trim().toLowerCase();
      if (scelta.equalsIgnoreCase("esci"))
        break;
    }

    // Distruzione scanner
    scannerNum.close();
    scannerString.close();
  }

  
}
