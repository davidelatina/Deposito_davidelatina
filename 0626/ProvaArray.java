import java.util.Scanner;

public class ProvaArray {
  public static void main(String[] args) {
    // Dichiarazione
    Scanner scannerNum = new Scanner(System.in);
    // non inizializzato
    int[] numeri = new int[5];

    // inizializzazione diretta
    int[] valori = {1, 2, 3, 4, 5};

    System.out.println("Primo numero: " + valori[0]);

    // riempimento array
    System.out.println("Inserire 5 numeri:");
    for (int i = 0; i < numeri.length; i++) {
      numeri[i] = scannerNum.nextInt();
    }

    System.out.print("Numeri inseriti: ");
    for (int i = 0; i < numeri.length; i++) {
      System.out.print(numeri[i] + ", ");
    }
    System.out.println("");



    // Array 2D
    int[][] matrice = new int[3][3];

    int[][] matricePredefinita = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    // Stampa
    for (int i = 0; i < matrice.length; i++) {
      for (int j = 0; j < matrice[i].length; j++) {
        System.out.print(matricePredefinita[i][j] + ", ");
      }
      System.out.println("");
    }

    scannerNum.close();
  }

}
