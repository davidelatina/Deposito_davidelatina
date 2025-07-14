
// Adapter Target interface --- Subject

import java.util.ArrayList;
import java.util.List;

interface SmartHomeSystem extends Subject {
  void performSensorReading();
  static SmartHomeSystem giveAdapter() {
    return new SmartHomeAdapter();
  };
}

// Adaptee
class PhilipsSmartSensor {
  SmartHomeNotification getAirQualityReading() {
    String message;
    if (Math.random() * 2 > 1) {
      message = "Qualità aria bassa";
    } else {
      message = "Qualità aria normale";
    }
    return new SmartHomeNotification(message);
  }
}

// Adapter / Subject
class SmartHomeAdapter implements SmartHomeSystem {

  // Subject
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

  //Adapter
  private PhilipsSmartSensor philipsSmartSensor;

  public SmartHomeAdapter() {
    this.philipsSmartSensor = new PhilipsSmartSensor();
  }

  public SmartHomeSystem giveAdapter() {
    return new SmartHomeAdapter();
  }

  public void performSensorReading() {
    notifyObservers(philipsSmartSensor.getAirQualityReading());
  }
}
