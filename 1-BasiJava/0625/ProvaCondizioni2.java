import java.util.Scanner;

public class ProvaCondizioni2 {
  public static void main(String[] args) {
    // Creazione oggetto Scanner
    Scanner ScannerNum =    new Scanner(System.in);


    // Età
    System.out.println("Inserire età cliente (int):");
    int età = ScannerNum.nextInt();

    // Biglietto valido
    System.out.println("Cliente possiede biglietto valido? (bool)");
    boolean bigliettoValido = ScannerNum.nextBoolean();

    // Accompagnato da adulto
    boolean clienteAccompagnato = false;
    if (età < 18) {
      System.out.println("Cliente accompagnato da adulto? (bool)");
      clienteAccompagnato = ScannerNum.nextBoolean();
    }
    
    // Opzione salta la fila
    System.out.println("Cliente ha acquistato l'opzione \"salta la fila\"? (bool)");
    boolean saltaFila = ScannerNum.nextBoolean();

    // taxi o bus
    System.out.println("Cliente vuole usare taxi (true) o bus (false)? (bool)");
    boolean taxi = ScannerNum.nextBoolean();

    // età invalida
    if (età < 0) {
      System.out.println("Il cliente non può entrare");
      System.out.println("Età inserita invalida.");
    } 
    else if (!bigliettoValido) {
      System.out.println("Il cliente non può entrare");
      System.out.println("Biglietto invalido");
    } // troppo giovane per il taxi
    else if (età >= 16 && età < 18 && !clienteAccompagnato && taxi) {
      System.out.println("Il cliente non può entrare");
      System.out.println("Tra i 16 e i 18 anni, se non accompagnati bisogna usare il bus.");
    } //minore accompagnato o maggiorenne, con biglietto valido, o 16enne su bus
    else if ((età < 18 && clienteAccompagnato) || età >= 18) {
      System.out.print("Il cliente può entrare");
      // opzione salta fila
      if (saltaFila) {
        System.out.print(" e saltare la fila.");
      }
      System.out.println();
    } else {
      System.out.println("Il cliente non può entrare");
    }

    // Distruzione scanner
    ScannerNum.close();
  }
}
