public class EsercizioCostruttori {
  public static void main(String[] args) {
    Libro libro1 = new Libro("Libro1", "Autore1", 5.0);
    Libro libro2 = new Libro("Libro2", "Autore2", 10.0);

    System.out.println("Ci sono " + Libro.contatore() + " libri:");
    libro1.stampaLibro();
    libro2.stampaLibro();
  } 
}

class Libro {
  static int totaleLibri = 0; // Variabile statica

  // Variabili di istanza
  String nome; 
  String autore;
  double prezzo;
  int codice_numerico_autoincrementante;
  
  Libro(String nome, String autore, double prezzo) {
    this.nome = nome;
    this.autore = autore;
    this.prezzo = prezzo;
    totaleLibri++; // Incremento per ogni nuovo oggetto
    // assegno il codice
    this.codice_numerico_autoincrementante = totaleLibri;
  }

  static int contatore() {
    return totaleLibri;
  }

  void stampaLibro() {
    System.out.println(this.codice_numerico_autoincrementante + ". " 
      + this.nome + " - " + this.autore + " - € " + this.prezzo);
  }
}
