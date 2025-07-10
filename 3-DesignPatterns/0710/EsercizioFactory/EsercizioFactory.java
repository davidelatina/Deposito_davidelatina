/*
Interfaccia IVeicolo

Metodo void Avvia()

Metodo void MostraTipo()


Classi concrete che implementano IVeicolo:

Auto → stampa "Avvio dell'auto" e "Tipo: Auto"
Moto → stampa "Avvio della moto" e "Tipo: Moto"
Camion → stampa "Avvio del camion" e "Tipo: Camion"


Crea una classe VeicoloFactory con:

Metodo statico IVeicolo CreaVeicolo(string tipo) che:
restituisce un oggetto Auto se tipo == "auto"
restituisce un oggetto Moto se tipo == "moto"
restituisce un oggetto Camion se tipo == "camion"
altrimenti restituisce null o stampa un messaggio di errore


Nel Main:

Chiedi all’utente quale veicolo creare
Usa VeicoloFactory.CreaVeicolo(...)
Se il veicolo è valido, chiamane i metodi Avvia() e MostraTipo()


 */

class EsercizioFactory {
  public static void main(String[] args) {

    VeicoloFactory myVeicoloFactory = new VeicoloFactory();

    IVeicolo auto = myVeicoloFactory.creaVeicolo("auto");
    IVeicolo moto = myVeicoloFactory.creaVeicolo("moto");
    IVeicolo camion = myVeicoloFactory.creaVeicolo("camion");

    auto.avvia();
    auto.mostraTipo();

    moto.avvia();
    moto.mostraTipo();

    camion.avvia();
    camion.mostraTipo();

    IVeicolo invalido = myVeicoloFactory.creaVeicolo("quad");

    if (invalido == null) {
      System.out.println("Non abbiamo i quad");
      return;
    } else {
      invalido.avvia();
      invalido.mostraTipo();
    }

  }
}

// Product Interface
interface IVeicolo {

  void avvia();

  default public void mostraTipo() {
    System.out.println("Tipo: " + this.getClass());
  }

}

// Concrete Product
class ProductAuto implements IVeicolo {
  @Override
  public void avvia() {
    System.out.println("Avvio dell'auto");
    mostraTipo();
  }
}

// Concrete Product
class ProductMoto implements IVeicolo {
  @Override
  public void avvia() {
    System.out.println("Avvio della moto ");
    mostraTipo();
  }
}

// Concrete Product
class ProductCamion implements IVeicolo {
  @Override
  public void avvia() {
    System.out.println("Avvio del camion");
    mostraTipo();
  }
}

// Creator: dichiara il Factory Method
abstract class AbstractVeicoloFactory {
  // Factory Method: restituisce un Product
  public abstract IVeicolo creaVeicolo(String tipo);
}

// Concrete Creator
class VeicoloFactory extends AbstractVeicoloFactory {
  @Override
  public IVeicolo creaVeicolo(String tipo) {
    if (tipo.equals("auto")) {
      return new ProductAuto();
    } else if (tipo.equals("moto")) {
      return new ProductMoto();
    } else if (tipo.equals("camion")) {
      return new ProductCamion();
    }

    System.out.println("Tipo veicolo invalido.");
    return null;
  }
}
