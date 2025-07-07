/*
Titolo: Gestione di una Scuola – Esercizio OOP completo

Obiettivo:
  Progettare un sistema che rappresenti una scuola con più tipologie di persone (studenti e docenti), applicando tutte le regole dell’OOP:
  Incapsulamento: dati privati con metodi getter e setter
  Ereditarietà: classi che estendono una classe base comune
  Polimorfismo: metodo sovrascritto chiamato su riferimenti generici
  Astrazione: uso di classe astratta e interfaccia

Traccia:
  Classe Astratta Persona
  Attributi privati: nome (String), età (int)
  Costruttore con parametri
  Metodi getter/setter
  Metodo astratto descriviRuolo()
  Interfaccia Registrabile
  Metodo: registrazione() che stampa la modalità di registrazione della persona

  Classe Studente (extends Persona, implements Registrabile)

    Attributo: classeFrequentata (String)
    Override di descriviRuolo() che stampa “Sono uno studente della classe …”
    Implementazione di registrazione() che stampa “Registrazione tramite modulo online”

  Classe Docente (extends Persona, implements Registrabile)
    Attributo: materia (String)
    Override di descriviRuolo() che stampa “Sono un docente di …”
    Implementazione di registrazione() che stampa “Registrazione tramite segreteria didattica”

  Classe Principale GestioneScuola
  Istanzia una lista di tipo Persona con oggetti Studente e Docente
  Usa un ciclo per chiamare descriviRuolo() e registrazione() su ogni elemento della lista


Requisiti Obbligatori:
  I campi devono essere privati → incapsulamento
  L’interfaccia e la classe astratta devono essere usate → astrazione
  Le classi concrete devono derivare da una classe base → ereditarietà
  I metodi devono essere richiamati da riferimenti generici → polimorfismo

*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

abstract class Persona {
  private String nome;
  private int eta;
  
  public Persona(String nome, int eta) {
    this.nome = nome;
    this.eta = eta;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getEta() {
    return eta;
  }

  public void setEta(int eta) {
    this.eta = eta;
  }

  abstract void descriviRuolo();
  abstract void registrazione();
}

 interface Registrabile {
  void descriviRuolo();
  void registrazione();
}

class Studente extends Persona implements Registrabile {

  private String classeFrequentata;

  public String getClasseFrequentata() {
    return classeFrequentata;
  }

  public void setClasseFrequentata(String classeFrequentata) {
    this.classeFrequentata = classeFrequentata;
  }

  public Studente(String nome, int eta, String classeFrequentata) {
    super(nome, eta);
    this.classeFrequentata = classeFrequentata;
  }

  public void registrazione() {System.out.println("Registrazione tramite modulo online");}

  public void descriviRuolo() {
    System.out.println("Sono uno studente della classe di " + this.getClasseFrequentata());
  }
}

class Docente extends Persona implements Registrabile {

  private String materia;

  public String getMateria() {
    return materia;
  }

  public void setMateria(String materia) {
    this.materia = materia;
  }

  public Docente(String nome, int eta, String materia) {
    super(nome, eta);
    this.materia = materia;
  }

  public void registrazione() {
    System.out.println("Registrazione tramite segreteria didattica");
  }

  public void descriviRuolo() {
    System.out.println("Sono un docente di " + this.getMateria());
  }
}


public class GestioneScuola {
  public static void main(String[] args) {
    

    // dichiarazione scuola, alunni e docenti standard
    Scuola myScuola = new Scuola("Istituto Carlo Pinneo");
    myScuola.addStudente(new Studente("Qui", 14, "Storia"));
    myScuola.addStudente(new Studente("Quo", 14, "Economia"));
    myScuola.addStudente(new Studente("Qua", 14, "Scienze"));

    myScuola.addDocente(new Docente("Paperoga", 34, "Storia"));
    myScuola.addDocente(new Docente("de Paperoni", 65, "Economia"));
    myScuola.addDocente(new Docente("Archimede", 44, "Scienze"));

    myScuola.inizializza();

  }
}


class Scuola {
  // Classe Principale GestioneScuola
  // Istanzia una lista di tipo Persona con oggetti Studente e Docente
  // Usa un ciclo per chiamare descriviRuolo() e registrazione() su ogni elemento della lista

  private String nome;
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  ArrayList<Persona> persone;

  Scuola(String nome) {
    this.nome = nome;
    this.persone = new ArrayList<>();
  }

  public void addStudente(Studente s) {
    persone.add(s);
  }

  public void addDocente(Docente d) {
    persone.add(d);
  }


  public void inizializza() {

    for (Persona persona : persone) {
      persona.descriviRuolo();
      persona.registrazione();
      System.out.println();
    }
  }
}
