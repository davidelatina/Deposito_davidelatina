import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// logger sottoforma di singleton observer
public class SmartHomeAlerts implements Observer {

  // Istanza privata statica della classe Logger
  private static SmartHomeAlerts instance;

  // Costruttore privato per impedire l'istanziazione diretta
  private SmartHomeAlerts() {
  }

  // Metodo pubblico statico per ottenere l'unica istanza di Logger
  public static SmartHomeAlerts getInstance() {

    // Se l'istanza non esiste, viene creata
    if (instance == null) {
      instance = new SmartHomeAlerts();
    }
    // Restituisce l'istanza esistente
    return instance;
  }

  // Metodo per stampare un messaggio di log
  public void update(SmartHomeNotification message) {
    String dataOra = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    System.out.println("[LOG] " + "[" + dataOra + "] " + message.message());
  }
}