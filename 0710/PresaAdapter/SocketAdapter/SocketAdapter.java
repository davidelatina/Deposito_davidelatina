package SocketAdapter;

// Adaptee
class AmericanSocket {
  Electricity provideElectricity() {
    return new Electricity();
  }
}

// Adapter
public class SocketAdapter implements EuropeanSocket {
  private AmericanSocket americanSocket;

  public SocketAdapter() {
    this.americanSocket = new AmericanSocket();
  }

  public Electricity giveElectricity() {
    return americanSocket.provideElectricity();
  }
}
