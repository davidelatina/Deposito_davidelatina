import java.util.Scanner;

public class EsercizioWhile {
  public static void main(String[] args) {
    // Esercizio: login con tentativi limitati e conferma finale
    Scanner ScannerString = new Scanner(System.in);

    // Inserimento password
    int tentativo = 1;
    String password = "";
    while (tentativo <= 3) {
      System.out.println("Inserire password (tentativo " + tentativo +
        "/3): ");
      password = ScannerString.nextLine();
    
      // Password corretta inserita
      if (password.equals("java123")) break;
      // Password errata
      System.out.println("Password errata.");
      tentativo++;
    }
    // Solo se l'utente è uscito dal ciclo per eccesso di tentativi
    if (tentativo == 4) {
      System.out.println("Accesso bloccato.");
    } else {
      String selezione = "s";
      // Richiesta accesso
      do {
        System.out.println("Vuoi accedere al sistema? (s/n)");
        selezione = ScannerString.nextLine();
      } while (!(selezione.equalsIgnoreCase("s") || selezione.equalsIgnoreCase("n")));

      // Selezione effettuata
      if (selezione.equalsIgnoreCase("s")) {
        System.out.println("Accesso effettuato");
      } else {
        System.out.println("Accesso annullato");
      }
    }
    
    // Rimozione scanner
    ScannerString.close();
  }
}
