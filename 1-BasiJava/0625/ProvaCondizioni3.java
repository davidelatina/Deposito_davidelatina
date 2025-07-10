import java.util.Scanner;

public class ProvaCondizioni3 {
  public static void main(String[] args) {
    // Partecipazione gara sportiva
    // Creazione oggetto Scanner
    Scanner ScannerNum = new Scanner(System.in);

    boolean ammesso = true;
    // 1. età compresa tra 18 e 40
    // 2. corso almeno una volta 100 metri in meno di 12 secondi
    // 3. BMI inferiore a 15
    //    BMI = peso / Math.pow(altezza, 2)

    // chiedere: età, miglior tempo 100 m, peso, altezza
    // verifica condizioni con operatori logici
    // usare una funzione math
    // stampare ammesso alla gara o non ammesso alla gara

    System.out.println("Inserire età:");
    int età = ScannerNum.nextInt(); 
    if (età < 18 || età > 40 + 1) ammesso = false;
    
    // Tempo 100 metri
    if (ammesso) {
      System.out.println("Inserire migliore tempo in 100 metri (in secondi, float):");
      float tempoCentoMetri = ScannerNum.nextFloat();
      if (tempoCentoMetri > 12 || tempoCentoMetri < 0)
        ammesso = false;
    }
    
    // Calcolo BMI
    if (ammesso) {
      System.out.println("Inserire peso (kg):");
      int peso = ScannerNum.nextInt();
      System.out.println("Inserire altezza (metri, float):");
      double altezza = ScannerNum.nextDouble();

      if (peso < 0 || altezza < 0) {
        // dati invalidi
        ammesso = false;
      }

      // Calcolo BMI
      double valoreBMI = peso / Math.pow(altezza, 2);
      if (valoreBMI > 25)
        ammesso = false;
    }

    // Stampa risultato finale
    if (ammesso) {
      System.out.println("Ammesso alla gara");
    } else {
      System.out.println("Non ammesso alla gara");
    }

    // extra: controllo dati
    // EXTRA: andate a gestire un numero randomico per ogni inserimento

    ScannerNum.close();
  }
  
}
