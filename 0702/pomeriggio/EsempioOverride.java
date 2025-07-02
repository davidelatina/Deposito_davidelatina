package pomeriggio;

class Veicolo { // Creazione di una classe genitore. definire un metodo
  void run() {
    System.out.println("Il veicolo è in marcia");
  }
}

class Bike extends Veicolo {

}

class Bike2 extends Veicolo {

  void run() {
    System.out.println("La bici sta correndo in sicurezza");
  } // metodo della classe genitore

}

class EsempioOverride {
  public static void main(String args[]) {
    Bike obj = new Bike();
    obj.run();

    Bike2 obj2 = new Bike2(); // crea oggetto
    obj2.run();
  }
}
