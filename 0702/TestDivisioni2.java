import java.util.InputMismatchException;
import java.util.Scanner;

public class TestDivisioni2 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Inserire numero: ");
      int numero = scanner.nextInt();
      int risultato = EsempioDivisione.divisioneUnchecked(numero, 0);
      System.out.println(risultato);
    } catch (InputMismatchException | ArithmeticException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
