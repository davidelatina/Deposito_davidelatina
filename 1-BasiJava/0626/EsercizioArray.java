import java.util.Scanner;

public class EsercizioArray {
  public static void main(String[] args) {
    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // chiedi quanti dolci ordinare
    int dolciTot = 0;
    while (true) {
      System.out.println("Quanti tipi di dolci vuoi ordinare?");
      dolciTot = scannerNum.nextInt();
      if (dolciTot < 0) {
        System.out.println("Inserire numero positivo o nullo");
      } else if (dolciTot > 10) {
        System.out.println("Troppi dolci! max 10");
      } else break;
    }

    // Dichiarazione array
    int[] dolciQuantità = new int[dolciTot];
    String[] dolciNomi = new String[dolciTot];

    // Inserimento dati
    for (int i = 0; i < dolciQuantità.length; i++) {
      // Nome dolce
      while (true) {
        System.out.println("Nome del dolce?");
        dolciNomi[i] = scannerString.nextLine();
        if (dolciNomi[i].isBlank()) {
          System.out.println("Inserire il nome del dolce");
        } else break;
      }

      // Quantità per ciascuno
      while (true) {
        System.out.println("Quanti ne vuoi ordinare?");
        dolciQuantità[i] = scannerNum.nextInt();
        if (dolciQuantità[i] < 0) {
          System.out.println("Inserire numero positivo o nullo");
        } else break;
      }
    }

    // Generazione costi casuali
    double[] dolciPrezzi = new double[dolciTot];

    for (int i = 0; i < dolciPrezzi.length; i++) {
      // Costo in euro. numero casuale tra 1 e 20
      dolciPrezzi[i] = (double) (int) (1 + Math.random() * 20);
      // Centesimi, numero casuale tra 0 e 100 diviso per 100
      dolciPrezzi[i] +=  ((double) (int) (Math.random() * 101)) / 100;
    }

    // Resoconto ordine
    double dolciCostoTotale = 0;
    System.out.println("Resoconto ordine: ");
    for (int i = 0; i < dolciQuantità.length; i++) {
      System.out.println(dolciNomi[i] + ":\t" + dolciQuantità[i] + 
        "\t€ " + dolciPrezzi[i] + " cad." +
        "\nSubtotale: \t€ " + dolciPrezzi[i]*dolciQuantità[i]);

      dolciCostoTotale += dolciPrezzi[i]*dolciQuantità[i];
    }
    System.out.println("TOTALE:\t€ " + dolciCostoTotale);

    // Chiusura scanner
    scannerString.close();
    scannerNum.close();
  }
}
