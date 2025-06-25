import java.util.Scanner;

public class EsempioMat {
  public static void main(String[] args) {
    // Creazione oggetto Scanner
    Scanner ScannerNum =    new Scanner(System.in);
    int a, b;
    System.out.print("inserire a: ");
    a = ScannerNum.nextInt();
    System.out.print("inserire b: ");
    b = ScannerNum.nextInt();
    System.out.print("Il massimo tra i due è " + Math.max(a, b) + "\n");
    System.out.print("Il minimo tra i due è " + Math.min(a, b) + "\n");
    System.out.println("sqrt(" + a + ") = " + Math.sqrt((double) a));
    // Distruzione scanner
    ScannerNum.close();
  }
}