/*
Esercizio 7: Editor di Testo con Plugin Aggiuntivi

Crea un editor di testo che consenta di decorare dinamicamente il
testo (grassetto, corsivo, sottolineato).

Usa Decorator per applicare i formati al testo.

Usa Strategy per permettere di cambiare modalità di salvataggio
(locale, cloud, criptato).
*/

import java.util.Scanner;
import MenuInput.*;

public class Main {
  public static void main(String[] args) {

    // Scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    // Contesto pagamento, decide strategia pagamento in base a subject
    SaveFileContext sistemaPagamento = new SaveFileContext();

    // Ossevatore metodo di pagamento desiderato dall'utente, dirige Pagamento_context
    DesiredPayment_concretesubject desiredPayment = new DesiredPayment_concretesubject();
    desiredPayment.registerObserver(sistemaPagamento);

    // Costo prodotto
    final double importoBiglietto = 23.5;




    // Input utente
    int sceltaNum = -1;
    char sceltaChar = '\0';

    // Loop principale programma, uscita scegliendo 1
    while (true) {

      System.out.println("\n   Biglietteria Online");
      System.out.println("1. Esci");
      System.out.printf("2. Compra Biglietto Treno € %.2f\n", importoBiglietto);
      //System.out.println("");
      //System.out.println("");
      //System.out.println("");
      //System.out.println("");


      sceltaNum = MenuInput.verifiedInputIntRange(1, 2, scannerNum, "Selezione: ", "");

      if (sceltaNum == 1) { // <-------------------------- USCITA DAL PROGRAMMA
        break;
      }

      switch (sceltaNum) {
        case 2:

          System.out.println("Selezionare metodo di pagamento: Paypal o Carta di credito?");
          sceltaChar = MenuInput.selectionByChar(scannerStr, "Selezione: ", "", new char[] {'p', 'c'});


          //sistemaPagamento.performTask(23.50);
          break;
         
        default:
          System.out.println("Errore selezione menu");
          break;
      }
    }

    scannerNum.close();
    scannerStr.close();  
  }
}
