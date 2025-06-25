import java.util.Scanner;

public class ProvaWhile {
  public static void main(String[] args) {
    // while

    // Inizializzazione variabile di controllo
    int i = 1;

    while (i <= 5) {
      i++;
      System.out.println(i);
    }

    // do...while
    Scanner input = new Scanner(System.in);
    int numero;

    do {
      System.out.print("Inserisci un numero (0 per uscire): ");
      numero = input.nextInt();
    } while (numero != 0);

    System.out.println("Hai inserito 0. Programma terminato.");
    input.close();
  }
}
