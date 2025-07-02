package mattina;

import java.util.Scanner;

public class EsempioEccezioni3 {
  public static void main(String[] args) {
    
    try (Scanner scanner = new Scanner(System.in)){
      System.out.println("Inserire un numero: ");
      int input = scanner.nextInt();
      System.out.println("Inserito: " + input);
      int x = input / 0;
      System.out.println("x = " + x);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
