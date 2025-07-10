package SocketAdapter;

// Target interface
public interface EuropeanSocket {
  Electricity giveElectricity();
  static EuropeanSocket giveSocket() {
    return new SocketAdapter();
  };
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

  public SocketAdapter() {
    this.americanSocket = new AmericanSocket();
  }

  public EuropeanSocket giveSocket() {
    return new SocketAdapter();
  }

  public Electricity giveElectricity() {
    return americanSocket.provideElectricity();
  }
}
