/*
Esercizio Facile:

Obiettivo: Applicare il pattern Strategy per eseguire operazioni matematiche base.

Richiesta:
  Crea un'interfaccia Operazione con un metodo int esegui(int a, int b).
  Implementa due strategie: Addizione e Moltiplicazione.
  Crea un Calcolatore (Context) che può eseguire l'operazione impostata.
  Scrivi un Main per testare il cambio di strategia a runtime.
 */

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Uso da parte del Client
    Calcolatore_context context = new Calcolatore_context();

    // Input utente
    Scanner scannerNum = new Scanner(System.in);
    System.out.print("Inserire a: ");
    int a = scannerNum.nextInt();
    scannerNum.nextLine(); // Scarica newline
    System.out.print("Inserire b: ");
    int b = scannerNum.nextInt();

    context.setStrategy(new Addizione_strategy_concrete());
    System.out.println("a + b = " + context.performTask(a, b));
    
    context.setStrategy(new Moltiplicazione_strategy_concrete());
    System.out.println("a * b = " + context.performTask(a, b));
  }
}