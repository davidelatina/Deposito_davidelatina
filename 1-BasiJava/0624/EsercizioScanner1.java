import java.util.Scanner;

public class EsercizioScanner1 {
  public static void main(String[] args) {
    // Creazione oggetti scanner
    Scanner StringScanner = new Scanner(System.in);
    Scanner NumScanner =    new Scanner(System.in);

    // String
    // Tre passaggi identici per ogni tipo base:
    // 1. Richiesta di input all'utente
    System.out.println("Inserire una stringa: ");
    // 2. Lettura input tramite Scanner
    String inputString = StringScanner.nextLine(); 
    // 3. Output risultato
    System.out.println("input: " + inputString);

    // boolean
    System.out.println("Inserire una variabile booleana: ");
    boolean inputBool = NumScanner.nextBoolean();  
    System.out.println("input: " + inputBool);

    // byte
    System.out.println("Inserire un byte: ");
    byte inputByte = NumScanner.nextByte();     
    System.out.println("input: " + inputByte);

    // double
    System.out.println("Inserire un double: ");
    double inputDouble = NumScanner.nextDouble();   
    System.out.println("input: " + inputDouble);

    // float
    System.out.println("Inserire un float: ");
    float inputFloat = NumScanner.nextFloat();    
    System.out.println("input: " + inputFloat);

    // int
    System.out.println("Inserire un int: ");
    int inputInt = NumScanner.nextInt();      
    System.out.println("input: " + inputInt);

    // Long
    System.out.println("Inserire un long: ");
    Long inputLong = NumScanner.nextLong();     
    System.out.println("input: " + inputLong);

    // short
    System.out.println("Inserire un short: ");
    short inputShort = NumScanner.nextShort();
    System.out.println("input: " + inputShort);


    // Distruzione oggetti Scanner
    StringScanner.close();
    NumScanner.close();
  }
}
