/*
Esercizio 4: Sistema di Notifiche per Smart Home

Simula una smart home dove dispositivi (sensori, luci, allarmi)
comunicano cambiamenti.

Usa Observer per notificare i cambiamenti di stato.

Usa Adapter per far comunicare dispositivi di produttori diversi.
 */

import java.util.*;

record SmartHomeNotification(String message) {
}

public class SmartHome {
  public static void main(String[] args) {
    // Istanziazione logger per le notifiche smart home
    SmartHomeAlerts.getInstance();

    CentralinaMeteoSmartHome centralinaMeteo = new CentralinaMeteoSmartHome();

    // Iscrizione
    centralinaMeteo.registerObserver(SmartHomeAlerts.getInstance());

    // messaggio meteo
    centralinaMeteo.performSensorReading();

    // Creazione adattatore attraverso interfaccia
    SmartHomeSystem philipsSmartSensor = SmartHomeSystem.giveAdapter();

    // Iscrizione logger all'adattatore
    philipsSmartSensor.registerObserver(SmartHomeAlerts.getInstance());

    // Lettura qualità aria da dispositivo attraverso l'adattatore/subject e il suo
    // observer
    philipsSmartSensor.performSensorReading();

  }

}

class CentralinaMeteoSmartHome implements Subject {
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

  // Dispositivo smart home
  void performSensorReading() {
    String message = "Prevista pioggia";

    notifyObservers(new SmartHomeNotification(message));
  }

}
