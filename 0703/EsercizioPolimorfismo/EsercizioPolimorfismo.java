package EsercizioPolimorfismo;

public class EsercizioPolimorfismo {
  public static void main(String[] args) {
    Persona aldo = new Persona("Aldo");
    Persona bruno = new Persona("Bruno");
    Persona carlo = new Pirata("Carlo");

    aldo.saluta();
    bruno.saluta();
    carlo.saluta();
  }
}

class Persona {
  String nome;

  Persona(String nome) {
    this.nome = nome;
  }

  void saluta() {
    System.out.println("Ciao, sono " + this.nome + "!");
  }
}


class Pirata extends Persona {

  Pirata(String nome) {
    super(nome);
  }

  void saluta() {
    super.saluta();
    System.out.println("Arrr!");
  }
}