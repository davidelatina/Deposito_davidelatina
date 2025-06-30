public class EsercizioCostruttori2 {
  public static void main(String[] args) {
    Persona aldo = new Persona("Aldo", 18);
    Persona bruno = new Persona("Bruno", 20, "Milano");
    System.out.println("Ci sono " + Persona.totale() + " persone:");
    aldo.print();
    bruno.print();
  }
}

class Persona {
  // Variabili statiche
  static int totale = 0;

  // Variabili di istanza
  String nome;
  int eta;
  String citta;

  // Costruttore parzialmente predefinito
  Persona(String nome, int eta) {
    totale++;
    this.nome = nome;
    this.eta = eta;
    this.citta = "Roma"; 
  }

  // Costruttore personalizzato
  Persona(String nome, int eta, String citta) {
    totale++;
    this.nome = nome;
    this.eta = eta;
    this.citta = citta;
  }

  static int totale() {
    return totale;
  }

  void print() {
    System.out.println(this.nome + " - " + 
      this.eta + " anni - vive a " + this.citta);
  }
}
