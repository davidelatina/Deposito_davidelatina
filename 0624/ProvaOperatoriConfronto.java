import java.util.Scanner;

public class ProvaOperatoriConfronto {
  public static void main(String[] args) {
    // Creazione oggetto Scanner
    Scanner NumScanner = new Scanner(System.in);

    // Richiesta input
    System.out.println("Inserire x e y (int): ");
    // Assegnazione
    int x = NumScanner.nextInt();
    int y = NumScanner.nextInt();
    System.out.println("x = " + x);
    System.out.println("y = " + y);

    // Logica
    System.out.print("x e y sono uguali? ");
    System.out.println(x == y);
    System.out.print("x è minore di y? ");
    System.out.println(x <= y);

    // Richiesta input
    System.out.println("Inserire a e b (int): ");
    // Assegnazione
    int a = NumScanner.nextInt();
    int b = NumScanner.nextInt();
    System.out.println("a = " + x);
    System.out.println("b = " + y);

    // Logica
    System.out.print("a e b sono uguali? ");
    System.out.println(a == b);
    System.out.print("a è minore di b? ");
    System.out.println(a <= b);

    System.out.print("x è minore di y, e al contempo a è minore di b? ");
    System.out.println(x <= y && a <= b);
    System.out.print("x è uguale a y, O a è uguale a b? ");
    System.out.println(x == y || a == b);
    System.out.print("O x è uguale a y, OPPURE a è uguale a b? ");
    System.out.println(!(x == y && a == b));
    

    // Distruzione oggetto Scanner
    NumScanner.close();
  }

}
