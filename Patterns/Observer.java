package Patterns;

import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
  void update(/* ARGS */);
}

// Interfaccia Subject
interface Subject {
  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
  private List<Observer> observers = new ArrayList<>();
  //private String state;

  public void setState(String state) {
    //this.state = state;
    notifyObservers();
  }

  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    if (observers.isEmpty()) {
      return;
    }
    for (Observer observer : observers) {
      observer.update();
    }
  }
}