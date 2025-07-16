import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
  void update(SaveFileStrategy strategy);
}

// Interfaccia Subject
interface Subject {
  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers(SaveFileStrategy strategy);
}

// ConcreteSubject
class DesiredPayment_concretesubject implements Subject {
  private List<Observer> observers = new ArrayList<>();
  private SaveFileStrategy strategy;

  public void setState(SaveFileStrategy strategyNew) {

    // con i singleton funzionerebbe anche ==
    if (strategyNew.equals(strategy)) {
      return;
    }

    System.out.println("\nMetodo di pagamento desiderato aggiornato.\n");
    this.strategy = strategyNew;
    notifyObservers(this.strategy);
  }

  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers(SaveFileStrategy strategy) {
    if (observers.isEmpty()) {
      return;
    }
    for (Observer observer : observers) {
      observer.update(strategy);
    }
  }
}