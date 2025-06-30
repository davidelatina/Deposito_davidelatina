public class EsempioCostruttore {
  public static void main(String[] args) {
    Studente studente1 = new Studente("Aldo");
    Studente studente2 = new Studente("Bruno");
    Studente studente3 = new Studente("Carlo");

    System.out.println("Ci sono " + Studente.contatore() + " studenti.");
  }
}

class Studente {
  String nome; // Variabile di istanza
  static int totaleStudenti = 0; // Variabile statica
  
  Studente(String nome) {
    this.nome = nome;
    totaleStudenti++; // Incremento per ogni nuovo oggetto
  }

  static int contatore() {
    return totaleStudenti;
  }
}