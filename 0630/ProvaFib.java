import java.util.Scanner;

public class ProvaFib {

  public static void main(String[] args) {
    // Scanner
    Scanner scannerInt = new Scanner(System.in);

    System.out.print("n-esimo numero di fibonacci.\ninserisci n:");

    int input = scannerInt.nextInt();

    System.out.println(fibonacci(input));

    scannerInt.close();
  } 
  
  private static int fibonacci(int n) {
    if (n < 1) {
      System.out.println("Errore");
      return -1;
    }
    if (n == 1 || n == 2) return 1;
    return fibonacci(n-1) + fibonacci(n-2);
  }
}
