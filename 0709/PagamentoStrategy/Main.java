/*
Esercizio Medio:

Obiettivo: 
  Gestire un sistema di pagamento che può variare il metodo in fase di esecuzione.

Richiesta:
    Crea un'interfaccia MetodoPagamento con void paga(double importo).
    Implementa almeno due strategie: CartaDiCredito e PayPal.
    Crea la classe PagamentoContext per assegnare e utilizzare il metodo scelto.
    Permetti all'utente di scegliere il metodo di pagamento e simula un acquisto stampando il metodo usato e l'importo pagato.
 */

import java.util.ArrayList;
import java.util.Scanner;
import MenuInput.*;

public class Main {
  public static void main(String[] args) {

    // Scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);

    // Contesto pagamento, decide strategia pagamento in base a subject
    Pagamento_context sistemaPagamento = new Pagamento_context();

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

          if (sceltaChar == 'p') {
            desiredPayment.setState(PayPal_strategy.getInstance());
          } else {
            desiredPayment.setState(CartaDiCredito_strategy.getInstance());
          }

          sistemaPagamento.performTask(23.50);
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
