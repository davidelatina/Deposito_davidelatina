public class ProvaIncapsulamento {
  public static void main(String[] args) {
    Person myObj = new Person();
    myObj.setName("Pippo"); // Settiamo il valore name = "pippo"
    System.out.println(myObj.getName());
  }
}

class Person {
  // Campi privati (incapsulamento)
  private String nome; // private
  private int eta; // Costruttore pubblico

  // Costruttore personalizzato
  public Person(String nome, int eta) {
    this.nome = nome;
    this.eta = eta;
  }
  // Costruttore vuoto
  public Person() {};

  // Getter
  public String getName() { 
    return nome;
  }

  // Setter
  public void setName(String newName) { 
    this.nome = newName;
  }

  // Metodo privato utilizzato dalla classe
  private boolean verificaMaggiorenne() {
    return this.eta >= 18;
  } 
  
  // Metodo pubblico che fa uso del metodo privato
  public void stampaStatus() {
    if (verificaMaggiorenne()) {
      System.out.println(this.nome + " è maggiorenne.");
    } else {
      System.out.println(this.nome + " non è maggiorenne.");
    }
  }
}
