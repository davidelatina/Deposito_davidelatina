/*
Esercizio: Gestione Flotta di una Compagnia Aerea (Incapsulamento)
Obiettivo:
  Allenati con l’incapsulamento in Java usando almeno tre classi collegate tra loro nel dominio dell’aeronautica.
Traccia:
  Crea queste tre classi:
    Aereo
      Attributi privati:
        modello (String)
        numeroPosti (int)
        codice (String, identificativo dell’aereo)
      Getter e setter per tutti gli attributi (il setter di numeroPosti deve accettare solo valori positivi).
    Pilota
      Attributi privati:
        nome (String)
        numeroBrevetto (String)
        oreVolo (int)
      Getter e setter per tutti gli attributi (il setter di oreVolo deve accettare solo valori maggiori di zero).
    CompagniaAerea
      Attributi privati:
        nome (String)
        flotta (ArrayList di oggetti Aereo)
        piloti (ArrayList di oggetti Pilota)
      Metodo per aggiungere un aereo alla flotta.
      Metodo per aggiungere un pilota.
      Metodo per stampare tutte le informazioni sulla flotta e i piloti della compagnia.
Obblighi minimi:
  Crea almeno due aerei e due piloti e aggiungili alla compagnia aerea.
  Stampa a schermo le informazioni della compagnia, mostrando dati di aerei e piloti.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento2 {
  public static void main(String[] args) {
    // Creazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // Creazione oggetto
    CompagniaAerea myCA = new CompagniaAerea("myCompagniaAerea");

    // Aggiunta di alcuni dati
    myCA.addAereo(new Aereo("Boeing", 300, "A001"));
    myCA.addAereo(new Aereo("Airbus", 250, "A002"));

    myCA.addPilota(new Pilota("Pippo", "pip001", 100));
    myCA.addPilota(new Pilota("Paperino", "pap313", 1));


    // Stampa
    myCA.print();


    // Chiusura scanner
    scannerNum.close();
    scannerString.close();
  }
}

class CompagniaAerea {
  // Variabili d'istanza
  private String nome;
  private ArrayList<Aereo> flotta;
  private ArrayList<Pilota> piloti;

  // Costruttore
  CompagniaAerea(String nome) {
    this.nome = nome;
    this.flotta = new ArrayList<>();
    this.piloti = new ArrayList<>();
  }

  // Aggiungi aereo alla flotta
  void addAereo(Aereo myAereo) {
    this.flotta.add(myAereo);
  }

  // Aggiungi pilota
  void addPilota(Pilota myPilota) {
    this.piloti.add(myPilota);
  }

  // Stampa informazioni

  // Info flotta
  void printFlotta() {
    System.out.println("Flotta " + this.nome + ":");
    for (Aereo aereo : flotta) {
      aereo.print();
    }
  }

  // Info piloti
  void printPiloti() {
    System.out.println("Piloti " + this.nome + ":");
    for (Pilota pilota : piloti) {
      pilota.print();
    }
  }

  // Stampa tutto
  void print() {
    printFlotta();
    printPiloti();
  }
}


class Pilota {
  // Variabili d'istanza
  private String nome;
  private String numeroBrevetto;
  private int oreVolo;

  // Costruttore
  Pilota(String nome, String numeroBrevetto, int oreVolo) {
    this.nome = nome;
    this.numeroBrevetto = numeroBrevetto;
    this.oreVolo = oreVolo;
  }

  // Getters e setters
  public String getNome() {
    return nome;
  }

  public String getNumeroBrevetto() {
    return numeroBrevetto;
  }

  public int getOreVolo() {
    return oreVolo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setNumeroBrevetto(String numeroBrevetto) {
    this.numeroBrevetto = numeroBrevetto;
  }

  public void setOreVolo(int oreVolo) {
    if (oreVolo <= 0) {
      System.out.println("Errore: inserire numero maggiore di zero.");
      return;
    }
    this.oreVolo = oreVolo;
  }

  // Stampa informazioni
  void print() {
    System.out.println(
      this.nome + " - " + this.numeroBrevetto + " - " + this.oreVolo + 
      (this.oreVolo == 1 ? " ora" : " ore") + " di volo");
  }
}

class Aereo {
  // Variabili d'istanza
  private String modello;
  private int numeroPosti;
  private String codice;

  // Costruttore
  Aereo(String modello, int numeroPosti, String codice) {
    this.modello = modello;
    this.numeroPosti = numeroPosti;
    this.codice = codice;
  }

  // Getters e setters
  public String getModello() {
    return modello;
  }

  public String getCodice() {
    return codice;
  }

  public int getNumeroPosti() {
    return numeroPosti;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  public void setModello(String modello) {
    this.modello = modello;
  }

  public void setNumeroPosti(int numeroPosti) {
    if (numeroPosti <= 0) {
      System.out.println("Inserire numero posti valido.");
      return;
    }
    this.numeroPosti = numeroPosti;
  }


  // Stampa informazioni
  void print() {
    System.out.println(this.codice + " - " + this.modello + " - " + this.numeroPosti + " posti");
  }
}
