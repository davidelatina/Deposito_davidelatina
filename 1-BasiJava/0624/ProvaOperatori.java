import java.util.Scanner;

public class ProvaOperatori {
  public static void main(String[] args) {
    // Creazione oggetto Scanner
    Scanner NumScanner =    new Scanner(System.in);

    // Richiesta input
    System.out.println("Inserire x (int): ");

    // Assegnazione
    int x = NumScanner.nextInt();
    System.out.println("x = " + x);

    // Assegnazione di addizione
    System.out.println("Inserire un int da aggiungere: ");
    int y = NumScanner.nextInt();
    x += y;
    System.out.println("x = " + x);

    // Assegnazione di sottrazione
    System.out.println("Inserire un int da sottrarre: ");
    y = NumScanner.nextInt();
    x -= y;
    System.out.println("x = " + x);

    // Assegnazione di moltiplicazione
    System.out.println("Inserire un int da moltiplicare: ");
    y = NumScanner.nextInt();
    x *= y;
    System.out.println("x = " + x);

    // Assegnazione di divisione
    System.out.println("Inserire un int per cui dividere: ");
    y = NumScanner.nextInt();
    x /= y;
    System.out.println("x = " + x);

    // Assegnazione di resto
    System.out.println("Inserire un int per il quale prendere il resto: ");
    y = NumScanner.nextInt();
    x %= y;
    System.out.println("x = " + x);

    // Distruzione oggetto Scanner
    NumScanner.close();
  }
  
}
