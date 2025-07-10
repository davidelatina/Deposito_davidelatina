public class ProvaCondizioni3extra {
  public static void main(String[] args) {
    // Partecipazione gara sportiva

    boolean ammesso = true;
    // 1. età compresa tra 18 e 40
    // 2. corso almeno una volta 100 metri in meno di 12 secondi
    // 3. BMI inferiore a 15
    //    BMI = peso / Math.pow(altezza, 2)

    // chiedere: età, miglior tempo 100 m, peso, altezza
    // verifica condizioni con operatori logici
    // usare una funzione math
    // stampare ammesso alla gara o non ammesso alla gara

    // età
    int età = 16 + (int) (Math.random() * 34); 
    System.out.println("età atleta: " + età);
    if (età < 18 || età > 40 + 1)
      ammesso = false;

    // Tempo 100 metri
    if (ammesso) {
      
      double tempoCentoMetri = 9.58 + Math.random() * 5;
      System.out.println("migliore tempo in 100 metri (in secondi, float): " +
        tempoCentoMetri);
      if (tempoCentoMetri > 12 || tempoCentoMetri < 0)
        ammesso = false;
    }
    
    // Calcolo BMI
    if (ammesso) {
      double peso = 60.0 + Math.random() * 60;
      System.out.println("peso atleta (kg): " + peso);
      
      double altezza = 1.40 + Math.random() * 0.80;
      System.out.println("Inserire altezza (metri, float):" + altezza);

      // Risultato
      double valoreBMI = peso / Math.pow(altezza, 2);
      System.out.println("Valore BMI: " + valoreBMI);
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
  }
  
}
