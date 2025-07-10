import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class EsercizioArrayList {
  public static void main(String[] args) {
    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // Crea arraylist di stringhe per memorizzare nomi di studenti
    ArrayList<String> studentiNomi = new ArrayList<>();

    // variabile temporanea per controllare i nomi inseriti
    String nomeTemp = "";

    // chiedi all'utente se vuole continuare
    String selezione = "";
    do {
      while (true) {
        System.out.print("Inserire nomi studenti da registrare, o \"fine\": ");
        nomeTemp = scannerString.nextLine();

        nomeTemp.trim();

        // utente aggiunge nomi finché non scrive "fine"
        if (nomeTemp.equalsIgnoreCase("fine")) {
          System.out.println("Fine inserimento nomi studenti.");
          break;
        } else if (nomeTemp.isBlank()) {
          System.out.println("Inserire un nome valido.");
        } else {
          studentiNomi.add(nomeTemp);
        }
      }

      // stampare numero di studenti inseriti
      System.out.println("Inseriti " + studentiNomi.size() + " studenti.");

      // stampare tutti i nomi in ordine alfabetico
      Collections.sort(studentiNomi);
      System.out.println("Lista studenti: " + studentiNomi);


      // chiedere di eliminare studenti
      while (true) {
        int i = -1; // indice per studente da eliminare
        System.out.print("Elimina studente o scrivi \"fine\": ");
        nomeTemp = scannerString.nextLine();

        // rimuovi spazi vuoti prima e dopo il nome
        nomeTemp.trim();

        // utente aggiunge nomi finché non scrive "fine"
        if (nomeTemp.equalsIgnoreCase("fine")) {
          System.out.println("Fine rimozione nomi studenti.");
          break;
        } 

        // stringa senza caratteri
        if (nomeTemp.isBlank()) {
          System.out.println("Inserire un nome valido.");
          continue;
        }

        // trova posizione studente da eliminare. -1 se non è presente
        i = studentiNomi.indexOf(nomeTemp);

        // studente non trovato
        if (i == -1) {
          System.out.println(nomeTemp + " non è presente nella lista.");
        } else { // studente trovato
          studentiNomi.remove(i);
        }
      }

    // stampare (di nuovo) numero di studenti inseriti
    System.out.println("Inseriti " + studentiNomi.size() + " studenti.");

    // stampare (di nuovo tutti i nomi in ordine alfabetico
    Collections.sort(studentiNomi);
    System.out.println("Lista studenti: " + studentiNomi);

    System.out.print("inserire x per uscire dal programma, " + 
      "o qualsiasi altro carattere per continuare: ");
    selezione = scannerString.nextLine();
    selezione.trim();
    selezione.charAt(0);
  } while (!selezione.equalsIgnoreCase("x"));

    // Chiusura scanner
    scannerString.close();
    scannerNum.close();
  }
  
}
