/*
Esercizio Medio – Sistema di Notifica Borsa

Obiettivo: Modellare un sistema in cui un'agenzia borsistica notifica più investitori su variazioni del valore azionario.

Requisiti:
  Creare un'interfaccia Investitore con il metodo notifica(String azione, double valore).

Implementare la classe AgenziaBorsa con:

  una lista di investitori registrati;

  metodi aggiungiInvestitore, rimuoviInvestitore, notificaInvestitori;

  un metodo aggiornaValoreAzione(String nome, double valore) che notifica gli investitori.

  Implementare almeno due classi Investitore, es. InvestitorePrivato e InvestitoreBancario, che rispondono con messaggi personalizzati.
*/

import java.util.Scanner;

import MenuInput.*;

public class MainBorsa {
  public static void main(String[] args) {
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerNum = new Scanner(System.in);

    // Subject
    AgenziaBorsa myABorsa = new AgenziaBorsa();

    // Observers
    InvestitorePrivato myIPrivato = new InvestitorePrivato("Pippo");
    InvestitoreBancario myIBancario = new InvestitoreBancario("Banca di Topolinia");

    myABorsa.aggiungiInvestitore(myIBancario);
    myABorsa.aggiungiInvestitore(myIPrivato);

    // Update observers
    myABorsa.aggiornaValoreAzione("Rockerduck", 1000.0);
    myABorsa.aggiornaValoreAzione("Bassotti Enterprises", 23.0);

    // Custom notification
    String azione = MenuInput.verifiedInputString(scannerStr,"Inserire nome azione: ", "", false, false, false);
    double valore = MenuInput.verifiedInputDoubleRange(0.0, Double.MAX_VALUE, scannerNum, "Inserire valore: ", "");
    myABorsa.aggiornaValoreAzione(azione, valore);

    scannerNum.close();
    scannerStr.close();
  }
 }

 