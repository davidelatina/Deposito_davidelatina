/*
Definire una Classe BankAccount e
Implementare Deposito & Prelievo
Crea una classe BankAccount con:
String accountHolderName (Nome del titolare dell'account)
double balance (Saldo)
Metodo void deposit(double amount) per effettuare un deposito
Metodo void withdraw(double amount) per effettuare un
prelievo
Metodo void displayBalance() per mostrare il saldo attuale
Assicurati che il prelievo non consenta un saldo negativo.

Extra: creare arraylist di account tra cui scegliere in base alle credeziali
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BankAccount {


  // Variabili di istanza
  String accountHolderName;
  double balance;

  BankAccount(String name) {
    this.accountHolderName = name;
    this.balance = 0.0;
  }

  /*
  // Effettuare un deposito
  void deposit(double amount) {

  }

  // Effettuare un prelievo
  void withdraw(double amount) {

  }
  
  // mostrare saldo attuale
  void displayBalance(Scanner scannerString) {
    
  }
  */

}

public class ProvaBanca {
  public static void main(String[] args) {
    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    
    int scelta = -1;
    String bufferName = "";
    double bufferMoney = -1.0;
    // String bufferPIN = "";

    ArrayList<BankAccount> clienti = new ArrayList<>();


    while (true) { // Loop principale programma


      // Selezione azione da parte dell'utente
      scelta = menuSelezione(scannerNum);

      if (scelta == 5) break;

      switch (scelta) {
        case 1:
          while (true) {
            System.out.print("Inserire nome cliente: ");
            bufferName = scannerString.nextLine();
            bufferName.trim();
            // No stringa vuota
            if (bufferName.isEmpty()) continue;
            // no duplicati
            boolean duplicato = false;
            for (BankAccount cliente : clienti) {
              if (cliente.accountHolderName.equalsIgnoreCase(bufferName)) {
                duplicato = true;
                break;
              }
            }
            if (!duplicato) break;
          }
          clienti.add(new BankAccount(bufferName));
          break;
        case 2:
          
          while (true) {
            System.out.println("Inserisci il nome del cliente: ");
            bufferName = scannerString.nextLine();
            boolean trovato = false;
            for (BankAccount cliente : clienti) {
              if (cliente.accountHolderName.equalsIgnoreCase(bufferName)) {
                System.out.println("Conto: € " + cliente.balance);
                trovato = true;
                break;
              }
            }
            if (trovato)
              break;
            System.out.println("Cliente non trovato");
          }
          break;
        case 3:
          System.out.println("Inserisci il nome del cliente: ");
          bufferName = scannerString.nextLine();
          for (BankAccount cliente : clienti) {
            if (cliente.accountHolderName.equalsIgnoreCase(bufferName)) {
              while (true) {
                System.out.println("Quanto depositare?");
                bufferMoney = scannerNum.nextDouble();
                if (bufferMoney < 0.0) {
                  System.out.println("Inserire un valore positivo");
                  continue;
                } else {
                  cliente.balance += bufferMoney;
                  break;
                }
              }
              break;
            }
          }
          break;
        case 4:
          System.out.println("Inserisci il nome del cliente: ");
          bufferName = scannerString.nextLine();
          for (BankAccount cliente : clienti) {
            if (cliente.accountHolderName.equalsIgnoreCase(bufferName)) {
              while (true) {
                System.out.println("Quanto prelevare?");
                bufferMoney = scannerNum.nextDouble();
                if (bufferMoney < 0.0) {
                  System.out.println("Inserire un valore positivo");
                  continue;
                } else if (bufferMoney > cliente.balance) {
                  System.out.println("Saldo insufficiente.");
                } else {
                  cliente.balance -= bufferMoney;
                  break;
                }
              }
              break;
            }
          }
          break;
        default:
          break;
      }
    }

    // Chiusura scanner
    scannerNum.close();
    scannerString.close();
  }

  // Menu di selezione
  static int menuSelezione(Scanner scannerNum) {
    int scelta = -1;
    while (true) { // Loop continuo di selezione. uscita con selezione valida
      System.out.println("   Banca Soldoni. Seleziona funzionalità:");
      System.out.println("1. Apri conto");
      System.out.println("2. Visualizza saldo");
      System.out.println("3. Deposito");
      System.out.println("4. Prelievo");
      System.out.println("5. Esci dal programma");

      System.out.print("");

      scelta = scannerNum.nextInt();

      if (1 <= scelta && scelta <= 5)
        return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a 5.");
    }
  }
}
