import java.util.Arrays;
import java.util.Scanner;

public class ProvaStringhe {
  public static void main(String[] args) {
    // Creazione oggetti scanner
    Scanner StringScanner = new Scanner(System.in);

    // Richiesta input utente
    System.out.println("Inserire una stringa:");
    String inputString = StringScanner.nextLine();

    // Primi tre metodi
    System.out.println("Lunghezza della stringa: " + inputString.length());
    System.out.println("Stringa in maiuscolo: " + inputString.toUpperCase());
    System.out.println("Stringa in minuscolo: " + inputString.toLowerCase());

    // Inserimento seconda stringa
    System.out.println(
      "Inserire una sottostringa " + 
      "per la quale cercare l'indice di prima occorrenza:");
    String inputSubString = StringScanner.nextLine();

    // Metodo equals()
    System.out.println("La sottostringa è uguale alla stringa? " +
      inputString.equals(inputSubString));

    // Metodo contains()
    System.out.println("La sottostringa è contenuta nella stringa? " +
      inputString.contains(inputSubString));

    // Metodo indexOf()
    System.out.println(
      "La sottostringa appare per la prima volta all'indice " +
      inputString.indexOf(inputSubString));

    // Concatenazione
    System.out.println("Concatenazione stringhe:");
    System.out.println(inputString.concat(inputSubString));

    // Test caratteri speciali
    System.out.println("Apostrofo: \'\nVirgolette: \"\nBackslash: \\");
    System.out.println("Tab: |\t|");
    System.out.println("Form feed: |\f|");

    // Test separazione stringhe
    String str = "Hello World";
    String[] words = str.split("\\s");
    System.out.println(Arrays.toString(words));
    
    // Distruzione oggetto Scanner
    StringScanner.close();
  }
  
}
