// Interfaccia Observer

import java.util.ArrayList;
import java.util.List;

interface Display {
  void aggiorna(float temperatura);
}

// Interfaccia Subject
interface Subject {
  void aggiungiDisplay(Display o);

  void rimuoviDisplay(Display o);

  void notificaDisplays();
}

// ConcreteSubject
class StazioneMeteoSubject implements Subject {
  private List<Display> displays = new ArrayList<>();
  private float temperatura;

  public void setTemperatura(float t) {
    this.temperatura = t;
    notificaDisplays();
  }

  public void aggiungiDisplay(Display o) {
    displays.add(o);
  }

  public void rimuoviDisplay(Display o) {
    displays.remove(o);
  }

  public void notificaDisplays() {
    if (displays.isEmpty()) {
      return;
    }
    for (Display d : displays) {
      d.aggiorna(this.temperatura);
    }
  }
}

// ConcreteObserver
class ConcreteObserver implements Display {
  private String name;

  public ConcreteObserver(String name) {
    this.name = name;
  }

  public void aggiorna(float t) {
    System.out.println(name + " ha ricevuto aggiornamento temperatura: " + t + " °C");
  }
}

class DisplayConsoleObserver extends ConcreteObserver {

  public DisplayConsoleObserver(String name) {
    super(name);
  }

}

class DisplayMobileObserver extends ConcreteObserver {

  public DisplayMobileObserver(String name) {
    super(name);
  }
}