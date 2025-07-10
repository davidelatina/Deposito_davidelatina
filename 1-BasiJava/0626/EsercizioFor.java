import java.util.Scanner;

public class EsercizioFor {
  public static void main(String[] args) {
    // Valutazione voti con controlli
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // L'utente vuole continuare l'esecuzione?
    char scelta;
    // Numero di voti da inserire
    int numeroVoti = 0;
    // somma dei voti
    int sommaVoti = 0;
    // media dei voti
    float mediaVoti = -1.0f;
    // nome studente
    String nomeStudente = "";

    while (true) { // break alla fine se l'utente sceglie 's'
      // chiedere nome studente
      nomeStudente = "";
      do {
        System.out.print("Inserire nome studente: ");
        nomeStudente = scannerString.nextLine();
      } while (nomeStudente.isEmpty());
      
      // Chiedere all'utente quanti voti inserire
      numeroVoti = 0;
      // while: validare che il numero sia maggiore di zero
      do {
        System.out.println("Quanti voti vuoi inserire? (>=1)");
        numeroVoti = scannerNum.nextInt();
      } while (numeroVoti < 1);

      // inserire ogni voto
      int votoInserito = -1;
      sommaVoti = 0;
      for (int i = 0; i < numeroVoti; i++) {
        while (true) { // continua fino all'ottenimento di un valore valido
          System.out.println("Inserire voto #" + (i + 1) + ": ");
          votoInserito = scannerNum.nextInt();
          // ogni voto deve essere compreso tra 0 e 30
          if (votoInserito < 0 || votoInserito > 30) {
            System.out.println("Voto non valido.");
          } else break;
        }
        // valutazione:
        // insufficiente sotto il 18
        // sufficiente tra 18 e 23, buono o ottimo da 24 in poi
        if (votoInserito < 18) {
          System.out.println("Voto insufficiente");
        } else if (votoInserito < 24) {
          System.out.println("Voto sufficiente");
        } else if (votoInserito < 30) {
          System.out.println("Voto buono o ottimo");
        } else {
          System.out.println("Voto massimo");
        }

        sommaVoti += votoInserito;
      }

      // stampa numero totale di voti validi inseriti
      System.out.println("Inseriti " + numeroVoti + " voti validi.");

      // extra: media voti
      mediaVoti = ((float) sommaVoti) / numeroVoti;
      System.out.println("Media dei voti di " + nomeStudente + ": " + mediaVoti);

      // valutazione finale
      System.out.print("Valutazione finale: ");
      if (mediaVoti < 18) {
        System.out.println("insufficiente");
      } else if (mediaVoti < 24) {
        System.out.println("sufficiente");
      } else if (mediaVoti < 30) {
        System.out.println("buona o ottima");
      } else {
        System.out.println("massimo dei voti");
      }

      // chiedi se continuare esecuzione
      do {
        System.out.println("Inserire i voti di un altro studente? (s/n)");
        scelta = scannerString.nextLine().toLowerCase().charAt(0);
      } while (scelta != 's' && scelta != 'n');
      
      if (scelta == 'n') break;
    }

    // Distruzione scanner
    scannerNum.close();
    scannerString.close();
  }
}
