import java.util.Scanner;

public class EsercizioSwitch {
  public static void main(String[] args) {
    /*
    Scrivi un programma Java che calcoli il preventivo per un'assicurazione auto
     in base ai seguenti criteri:
    1. Età del conducente:
    Meno di 18 anni → "Non sei idoneo per l'assicurazione"
    18 - 25 anni → Applica una maggiorazione del 20% sul prezzo base
    26 - 50 anni → Nessuna maggiorazione
    Più di 50 anni → Sconto del 10%
    2. Anni di esperienza alla guida:
    Meno di 2 anni → Applica una maggiorazione del 30% sul prezzo base
    2 o più anni → Nessuna maggiorazione
    3. Numero di incidenti negli ultimi 5 anni:
    0 incidenti → Nessun aumento
    1 incidente → Aumento del 15%
    2 o più incidenti → Aumento del 30%
    Più di 4 incidenti → "Non sei idoneo per l'assicurazione"
    4. Scelta del pacchetto assicurativo:
    Base: Prezzo standard
    Intermedio: +20%
    Premium: +50%
    Prezzo base dell'assicurazione: 500€
    */

    // Creazione oggetto Scanner
    Scanner ScannerNum =    new Scanner(System.in);
    Scanner ScannerString = new Scanner(System.in);

    int prezzoBase = 500;
    boolean escluso = false;
    double aumento = 1.0;
    int annoCorrente = 2025;
    int età_minima = 18;

    // Anagrafica con verifiche
    // Nome
    System.out.println("Inserisci nome:");
    String Nome = ScannerString.nextLine();
    Nome.trim();
    if (Nome.isEmpty()) {
      escluso = true;
      System.out.println("nome invalido");
    }

    // Cognome
    String Cognome = "";
    if (!escluso) {
      // Cognome
      System.out.println("Inserisci cognome:");
      Cognome = ScannerString.nextLine();

      Cognome.trim();
      if (Cognome.isEmpty()) {
        escluso = true;
        System.out.println("cognome invalido");
      }
    }
    
    // Anno di nascita
    int annoNascita = 0;
    if (!escluso) {
      System.out.println("Inserisci anno di nascita:");
      annoNascita = ScannerNum.nextInt();

      if (annoNascita > annoCorrente - (età_minima - 1)) {
        escluso = true;
        System.out.println("Troppo giovane per patente B");
      }
    }
    

    // numero di incidenti
    if (!escluso) {
      System.out.println("Quanti incidenti negli ultimi 5 anni?");
      int incidenti = ScannerNum.nextInt();
      switch (incidenti) {
        case 0:
          break;
        case 1:
          aumento += 0.15;
          break;
        case 2:
        case 3:
          aumento += 0.3;
          break;
        default:
          // o troppi incidenti o valore invalido
          escluso = true;
      }
    }
    
    // età conducente
    int età = 0;
    if (!escluso) {
      System.out.println("Inserire età");
      età = ScannerNum.nextInt();
      if (età < annoCorrente - annoNascita - 1 || età > annoCorrente - annoNascita + 1)
        escluso = true; // età non corrisponde ad anno di nascita
      if (età < 18)
        escluso = true;
      else if (età < 25)
        aumento += 0.2;
      // nulla se età tra 26 e 50
      else if (età > 50)
        aumento -= 0.1;
    }
    

    // anni esperienza alla guida
    if (!escluso) {
      System.out.println("Anni di esperienza alla guida?");
      int esperienza = ScannerNum.nextInt();
      if (esperienza < 0)
        escluso = true; // valore invalido
      if (età - esperienza < 14)
        escluso = true; // senza patente non conta
      else if (esperienza < 2)
        aumento += 0.3;
      // nulla altrimenti
    }
    


    // scelta pacchetto
    // TODO: riformulare con .equalsIgnoreCase()
    if (!escluso) {
      System.out.println("Selezionare pacchetto assicurativo: " +
        "Base (1), Intermedio (2) o Premium (3)");
      int pacchetto = ScannerNum.nextInt();

      if (pacchetto < 1 || pacchetto > 3) {
        System.out.println("Pacchetto invalido");
        escluso = true;
      } else
        switch (pacchetto) {
          case 1: // non cambia nulla
            break;
          case 2:
            aumento += 0.2;
            break;
          case 3:
            aumento += 0.5;
            break;
          default:
        }
    }
    

    // Risultato finale
    if (escluso) {
      System.out.println("Escluso.");
    } else {
      System.out.println("Approvato. Gentile " + Nome + " " + Cognome + 
        ", nato il " + annoNascita + ", pagherai " + prezzoBase*aumento + " euro");
    }


    // Distruzione scanner
    ScannerNum.close();
    ScannerString.close();
  }
}
