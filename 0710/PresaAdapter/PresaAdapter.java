
/*
Esercizio Facile

Creare un adattatore per collegare una presa europea a un dispositivo con presa americana.
    Creare un'interfaccia chiamata EuropeanSocket con un metodo giveElectricity().
    Realizzare una classe chiamata AmericanSocket con un metodo provideElectricity().
    Implementare un Adapter chiamato SocketAdapter che utilizzi AmericanSocket ma implementi EuropeanSocket.
    Testare l'adattatore collegandolo ad un dispositivo europeo.
 */

// Classe di oggetti fantoccio per testare il programma
class Electricity {}

// Target interface
interface EuropeanSocket {
  Electricity giveElectricity();
}

// Adaptee
class AmericanSocket {
  Electricity provideElectricity() {
    return new Electricity();
  }
}

// Adapter
class SocketAdapter implements EuropeanSocket {
  private AmericanSocket americanSocket;

  SocketAdapter() {
    this.americanSocket = new AmericanSocket();
  }
  
  public Electricity giveElectricity() {
    return americanSocket.provideElectricity();
  }
}

// Client
class PresaAdapter {
  public static void main(String[] args) {

    // Creazione adattatore attraverso interfaccia
    EuropeanSocket americanToEuAdapter = new SocketAdapter();

    // Creazione dispositivo che necessita di elettricità
    Dispositivo dispositivo = new Dispositivo();

    // Provvista di elettricità al dispositivo attraverso l'adattatore
    dispositivo.turnOn(americanToEuAdapter.giveElectricity());
  }
}

class Dispositivo {
  void turnOn(Object corrente) {
    if (corrente instanceof Electricity) {
      System.out.println("Dispositivo acceso.");
    } else {
      System.out.println("Dispositivo non si accende.");
    }
  }
}