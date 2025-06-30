import java.util.Scanner;

public class EsercizioRecap {
  public static void main(String[] args) {
    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // Dichiarazione variabili
    // Scelta dell'utente, varia da 1 a 5
    int scelta = -1;

    // 1. Somma di due numeri
    int addendo1 = 0, addendo2 = 0;

    // 2. Moltiplicazione in Overloading
    int fattoreInt1 = 0, fattoreInt2 = 0;
    double fattoreDouble1 = 0.0, fattoreDouble2 = 0.0;
    String sceltaCaso2 = ""; // per scegliere tra int e double

    // 3. Ricorsione - Somma dei Numeri Naturali
    int sommaNaturaliIndice = -1;
    int sommaNaturaliRisultato = -1;

    // 4. Passaggio per Valore & Passaggio per Riferimento
    int variabilePrimitiva = 0;
    int[] numeri = {1, 2, 3};
    String sceltaCaso4 = ""; // per scegliere tra variabile primitiva o elemento di array

    while (true) { // loop principale programma. si esce inserendo 5

      // Selezione programma da parte dell'utente
      scelta = menuSelezione(scannerNum);

      if (scelta == 5) break; // <--- uscita dal programma

      switch (scelta) {
        // 1. Somma di due numeri
        case 1: 
          System.out.println("Inserire due numeri interi: ");
          addendo1 = scannerNum.nextInt();
          addendo2 = scannerNum.nextInt();
          System.out.println("La loro somma è " + somma(addendo1, addendo2));
          break;
        // 2. Moltiplicazione in Overloading
        case 2: 
          while (true) {
            System.out.print("Vuoi moltiplicare numeri interi o double? (i/d): ");
            sceltaCaso2 = scannerString.nextLine();

            // Una stringa vuota porta .charAt(0) a lanciare un'eccezione
            if (sceltaCaso2.isEmpty())
              continue;

            sceltaCaso2.trim().toLowerCase();
            if (sceltaCaso2.charAt(0) == 'i' || sceltaCaso2.charAt(0) == 'd')
              break;
          }
          switch (sceltaCaso2.charAt(0)) {
            case 'i':
              System.out.println("Inserire due numeri interi: ");
              fattoreInt1 = scannerNum.nextInt();
              fattoreInt2 = scannerNum.nextInt();
              System.out.println("Il prodotto è " + prodotto(fattoreInt1, fattoreInt2));
              break;
            case 'd':
              System.out.println("Inserire due numeri a virgola mobile: ");
              fattoreDouble1 = scannerNum.nextDouble();
              fattoreDouble2 = scannerNum.nextDouble();
              System.out.println("Il prodotto è " + prodotto(fattoreDouble1, fattoreDouble2));
              break;
            default:
              System.out.println("Errore selezione caso 2");
          }
          break;
        // 3. Ricorsione - Somma dei Numeri Naturali
        case 3:
          System.out.print("Inserire un numero intero >= 0: ");
          sommaNaturaliIndice = scannerNum.nextInt();
          sommaNaturaliRisultato = sommaNaturali(sommaNaturaliIndice);
          if (sommaNaturaliIndice >= 0) {
            System.out.println("La somma dei numeri naturali fino a " +
              sommaNaturaliIndice + " è " + sommaNaturaliRisultato);
          } else {
            System.out.println("Errore!");
          }
          break;
        // 4. Passaggio per Valore & Passaggio per Riferimento
        case 4:
        while (true) {
          System.out.print("Vuoi modificare una variabile o un array? (v/a): ");
          sceltaCaso4 = scannerString.nextLine();

          // Una stringa vuota porta .charAt(0) a lanciare un'eccezione
          if (sceltaCaso4.isEmpty())
            continue;

          sceltaCaso4.trim().toLowerCase();
          if (sceltaCaso4.charAt(0) == 'v' || sceltaCaso4.charAt(0) == 'a')
            break;
        }
        switch (sceltaCaso4.charAt(0)) {
          case 'v':
            System.out.println("Inserire un numero intero: ");
            variabilePrimitiva = scannerNum.nextInt();
            modifica(variabilePrimitiva);
            System.out.println("Dopo aver chiamato la funzione .modifica() " +
              "sulla variabile primitiva, il suo valore è ancora " + variabilePrimitiva);
            break;
          case 'a':
            System.out.println("Inserire il primo elemento dell'array (numero intero): ");
            numeri[0] = scannerNum.nextInt();
            modifica(numeri);
            System.out.println("Ora numeri[0] ha valore "+ numeri[0]);
            break;
          default:
            System.out.println("Errore selezione caso 4");
        }
         break;
        default: // non dovrebbe essere raggiungibile
          System.out.println("Errore selezione programma");
          break;
      }
      System.out.println("");
    }


   
    // Chiusura scanner
    scannerNum.close();
    scannerString.close();
  }

  // Menu di selezione
  static int menuSelezione(Scanner scannerNum) {
    int scelta = -1;
    while (true) { // Loop continuo di selezione. uscita con selezione valida
      System.out.println("   Esercizio recap. Seleziona funzionalità:");
      System.out.println("1. Somma di due numeri");
      System.out.println("2. Moltiplicazione in Overloading");
      System.out.println("3. Ricorsione - Somma dei Numeri Naturali");
      System.out.println("4. Passaggio per Valore & Passaggio per Riferimento");
      System.out.println("5. Esci dal programma");

      System.out.print("Programma: ");

      scelta = scannerNum.nextInt();

      if (1 <= scelta && scelta <= 5) return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a 5.");
    }
  }

  // 1. Somma di due numeri
  static int somma(int a, int b) {
    return a + b;
  }


  // 2. Moltiplicazione in Overloading
  static int prodotto(int a, int b) {
    return a*b;
  }
  static double prodotto(double a, double b) {
    return a*b;
  }

  // 3. Ricorsione - Somma dei Numeri Naturali
  static int sommaNaturali(int n) {
    if (n < 0) {
      System.out.println("Errore");
      return -1;
    }
    if (n == 0) return 0;

    return n + sommaNaturali(n-1);
  }

  // 4. Passaggio per Valore & Passaggio per Riferimento
  static void modifica(int[] arr) {
    arr[0] = 99; // Questa modifica sarà visibile all'esterno
  }

  static void modifica(int input) {
    input = 99; // Questa modifica invece no
  }

  // Extra: fare una funzione che scorra un arraylist
}
