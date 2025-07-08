/*
Esercizio Medio:

Obiettivo: simulare un sistema di ordini di hamburger usando il pattern Decorator.

Richiesta:

Crea un'interfaccia Hamburger con i metodi String getDescrizione() e double
getPrezzo().

Implementa la classe concreta BaseBurger.

Crea almeno due decoratori concreti: FormaggioDecorator (+0.50€) e BaconDecorator
(+0.80€).

Permetti la combinazione di più decoratori per un singolo ordine.

Scrivi un Main che costruisce un hamburger con entrambi gli extra e ne stampa
descrizione e prezzo finale.
 */

import java.util.*;

public class HamburgerDecorator {
  public static void main(String[] args) {
    // Scanner scannerStr = new Scanner(System.in);
    // Scanner scannerNum = new Scanner(System.in);

    // Creazione hamburger con formaggio e bacon
    Hamburger ordine1 = new BaseBurger();
    ordine1 = new FormaggioDecorator(ordine1);
    ordine1 = new BaconDecorator(ordine1);

    // Creazione hamburger solo con bacon
    Hamburger ordine2 = new BaseBurger();
    ordine2 = new BaconDecorator(ordine2);

    // Creazione hamburger solo con formaggio
    Hamburger ordine3 = new BaseBurger();
    ordine3 = new FormaggioDecorator(ordine3);

    // Creazione hamburger base
    Hamburger ordine4 = new BaseBurger();

    // Creazione hamburger PRIMA bacon e POI formaggio
    Hamburger ordine5 = new BaseBurger();
    ordine5 = new BaconDecorator(ordine1);
    ordine5 = new FormaggioDecorator(ordine1);

    // Recupero singleton del gestore ordini
    GestoreOrdini_singleton gestore = GestoreOrdini_singleton.getInstance();

    // Notifica (observer)
    gestore.registerObserver(ordine1);
    gestore.registerObserver(ordine2);
    gestore.registerObserver(ordine3);
    gestore.registerObserver(ordine4);
    gestore.registerObserver(ordine5);

    // Riepilogo
    gestore.notifyObservers();

    // scannerStr.close();
    // scannerNum.close();
  }
}

// Interfaccia verso Component come Decorator, verso Subject come Observer
interface Hamburger {
  static int ingredientiNecessari = 0;

  // decorate component
  String getDescrizione();

  double getPrezzo();

  // update observer
  void update();
}

// Componente Concreto
class BaseBurger implements Hamburger {
  static int ingredientiNecessari = 0;

  public String getDescrizione() {
    return "Hamburger base, ";
  }

  public double getPrezzo() {
    return 3.00;
  }

  public void update() {
    ingredientiNecessari++;
  }
}

// Decoratore astratto
abstract class Decorator implements Hamburger {
  protected Hamburger component;

  public Decorator(Hamburger component) {
    contoIngredienti++;
    this.component = component;
  }

  public String getDescrizione() {
    return component.getDescrizione();
  }

  public double getPrezzo() {
    return component.getPrezzo();
  }

  static int ingredientiNecessari = 0;
  int contoIngredienti = 0;

  public void update() {
    ingredientiNecessari += contoIngredienti;
    contoIngredienti = 0;
  }
}

// Decoratori Concreti
class FormaggioDecorator extends Decorator {
  public FormaggioDecorator(Hamburger component) {
    super(component);
  }

  public String getDescrizione() {
    return component.getDescrizione() + "formaggio, ";
  }

  public double getPrezzo() {
    return component.getPrezzo() + 0.50;
  }

  static int ingredientiNecessari = 0;


}

class BaconDecorator extends Decorator {
  public BaconDecorator(Hamburger component) {
    super(component);
  }

  public String getDescrizione() {
    return component.getDescrizione() + "bacon, ";
  }

  public double getPrezzo() {
    return component.getPrezzo() + 0.80;
  }

}

// Interfaccia observer
interface Observer {
  void update(Hamburger h);
}

// Interfaccia Subject
interface Subject {
  void registerObserver(Hamburger hamburger);

  void removeObserver(Hamburger hamburger);

  void notifyObservers();
}

// Soggetto concreto e singleton
class GestoreOrdini_singleton implements Subject {

  // Singleton
  private static GestoreOrdini_singleton istanza;

  private GestoreOrdini_singleton() {

  }

  static public GestoreOrdini_singleton getInstance() {
    if (istanza == null) {
      istanza = new GestoreOrdini_singleton();
    }
    return istanza;
  }

  // Subject

  private List<Hamburger> hamburgers = new ArrayList<>();
  // private String state;

  public void setState(/* String state */) {
    // this.state = state;
    notifyObservers();
  }

  // register observer + LOG
  public void registerObserver(Hamburger hamburger) {
    hamburgers.add(hamburger);

    // copiato
    System.out
        .println("[GESTORE] Ordine registrato: " + hamburger.getDescrizione() + " - Prezzo: €" + hamburger.getPrezzo());
  }

  public void removeObserver(Hamburger hamburger) {
    hamburgers.remove(hamburger);
  }

  public void notifyObservers() {
    if (hamburgers.isEmpty()) {
      return;
    }
    for (Hamburger hamburger : hamburgers) {
      hamburger.update();
    }

    System.out.println("[CUCINA] Servono: ");
    System.out.println(BaseBurger.ingredientiNecessari + " panini e hamburger, " +
        BaconDecorator.ingredientiNecessari
        + " Fette di bacon," + FormaggioDecorator.ingredientiNecessari + " fette di formaggio");

  }
}