import java.util.ArrayList;
import java.util.List;

public class EsempioObserver {
  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();

    ConcreteObserver obs1 = new ConcreteObserver("obs1");
    ConcreteObserver obs2 = new ConcreteObserver("obs2");
    ConcreteObserver obs3 = new ConcreteObserver("obs3");

    subject.registerObserver(obs1);
    subject.registerObserver(obs2);
    subject.registerObserver(obs3);

    subject.setState("Stato 1");

    subject.removeObserver(obs3);

    subject.setState("Stato 2");
  }
}


// Interfaccia Observer
interface Observer {
  void update(String message);
}

// Interfaccia Subject
interface Subject {
  void registerObserver(Observer o);

  void removeObserver(Observer o);

  void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
  private List<Observer> observers = new ArrayList<>();
  private String state;

  public void setState(String state) {
    this.state = state;
    notifyObservers();
  }

  public void registerObserver(Observer o) {
    observers.add(o);
  }

  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  public void notifyObservers() {
    if (observers.isEmpty()) {
      return;
    }
    for (Observer o : observers) {
      o.update(state);
    }
  }
}

// ConcreteObserver
class ConcreteObserver implements Observer {
  private String name;

  public ConcreteObserver(String name) {
    this.name = name;
  }

  public void update(String message) {
    System.out.println(name + " ha ricevuto aggiornamento: " + message);
  }
}