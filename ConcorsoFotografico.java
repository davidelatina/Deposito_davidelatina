package Deposito_davidelatina;

import java.util.Scanner;

public class ConcorsoFotografico {
  public static void main(String[] args) {
    // dichiarazione e inizializzazione variabili
    Scanner scannerNum = new Scanner(System.in);

    int numFotoPremiate = 0;
    int[] fotoVotiGiudici = new int[5];

    // messaggio spiegazione input
    System.out.println("Programma di inserimento di 5 foto da votare");

    // inserimento voti delle foto
    for (int i = 0; i < fotoVotiGiudici.length; i++) {
      // input voto
      System.out.println("Inserire un voto da 1 a 10");
      fotoVotiGiudici[i] = scannerNum.nextInt();

      // controlla se il voto è un valore valido
      while (fotoVotiGiudici[i] < 1 || fotoVotiGiudici[i] > 10) {
        // input voto
        System.out.println("Errore: inserire un voto compreso tra 1 e 10");
        fotoVotiGiudici[i] = scannerNum.nextInt();
      }
    }

    for (int i = 0; i < fotoVotiGiudici.length; i++) {
      // controlla se ci sono foto premiate
      if (((fotoVotiGiudici[i] % 2) == 0) && (fotoVotiGiudici[i] >= 8)) {
        // stampa a schermo il voto della foto premiata
        System.out.println("Foto n." + (i + 1) + " premiata con il voto: " + fotoVotiGiudici[i]);

        // conteggio delle foto premiate
        numFotoPremiate++;
      }

    }
    // stampare numero totale foto premiate
    System.out.println("Il numero totale delle foto premiate è: " + numFotoPremiate);

    // stampare concorso annullato se nessuna foto riceve almeno 6 punti

    boolean FotoAlmenoSeiPunti = false;

    for (int i = 0; i < fotoVotiGiudici.length; i++) { // per ogni foto
      if (fotoVotiGiudici[i] >= 6) {
        FotoAlmenoSeiPunti = true; // <- questa è la variabile che devi aggiornare
        break; // esco dal ciclo interno
      }
    }

    if (FotoAlmenoSeiPunti == false) {
      System.out.println("Concorso annullato");
    }

    // chiusura dell'utilizzo dello scanner
    scannerNum.close();
  }
}
