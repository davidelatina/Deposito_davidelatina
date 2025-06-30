public class EsempioCalcolatrice {
  public static void main(String[] args) {
    Calcolatrice calc = new Calcolatrice();
    calc.saluta();
    int risultato = calc.somma(5, 3);
    System.out.println("La somma è: " + risultato);
  }
}

class Calcolatrice {

  // Metodo con ritorno
  int somma(int a, int b) {
    return a + b;
  }

  // Metodo senza ritorno
  void saluta() {
    System.out.println("Ciao!");
  }
}
