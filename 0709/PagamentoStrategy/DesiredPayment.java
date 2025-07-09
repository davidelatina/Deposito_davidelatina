import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
  void update(Pagamento_strategy strategy);
}

// Interfaccia Subject
interface Subject {
  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers(Pagamento_strategy strategy);
}

// ConcreteSubject
class DesiredPayment_concretesubject implements Subject {
  private List<Observer> observers = new ArrayList<>();
  //private Pagamento_strategy state;

  public void setState(Pagamento_strategy state) {
    System.out.println("\nMetodo di pagamento desiderato aggiornato.\n");
    //this.state = state;
    notifyObservers(state);
  }

  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers(Pagamento_strategy strategy) {
    if (observers.isEmpty()) {
      return;
    }
    for (Observer observer : observers) {
      observer.update(strategy);
    }
  }
}