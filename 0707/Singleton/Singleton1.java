class Pippo {
  String nome = "Pippo";
}

// Definizione della classe Singleton
public class Singleton1 {

  // Istanza privata statica della classe Singleton
  private static Singleton1 instance;

  // Oggetto del singleton
  private Pippo pippo;

  public Pippo getPippo() {
    return pippo;
  }

  // Costruttore privato per impedire l'istanziazione diretta
  private Singleton1() {
    this.pippo = new Pippo();
  }

  // Metodo pubblico statico per ottenere l'unica istanza della classe
  public static Singleton1 getInstance() {

    // Se l'istanza non esiste, viene creata
    if (instance == null) {
      instance = new Singleton1();
    }
    
    // Restituisce l'istanza esistente o appena creata
    return instance;
  }

  // Metodo di esempio che può essere chiamato sull'istanza Singleton
  public void doSomething() {

    // pippo.faiAzione()

    // Stampa
    System.out.println("Singleton1: DoSomething() called");
  }
}