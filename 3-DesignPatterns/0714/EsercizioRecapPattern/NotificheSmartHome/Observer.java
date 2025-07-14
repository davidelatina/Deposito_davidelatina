import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
  void update(SmartHomeNotification message);
}

// Interfaccia Subject
interface Subject {
  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers(SmartHomeNotification message);
}
/*
// ConcreteSubject
class ConcreteSubject implements Subject {
  private List<Observer> observers = new ArrayList<>();

  public void sendMessage(SmartHomeNotification message) {
    notifyObservers(message);
  }

  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers(SmartHomeNotification message) {
    if (observers.isEmpty()) {
      return;
    }
    for (Observer observer : observers) {
      observer.update(message);
    }
  }
}
  */