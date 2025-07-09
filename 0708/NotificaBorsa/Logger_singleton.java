import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Definizione della classe Logger come singleton
public class Logger_singleton {

  // Istanza privata statica della classe Logger
  private static Logger_singleton instance;

  // Costruttore privato per impedire l'istanziazione diretta
  private Logger_singleton() {
  }

  // Metodo pubblico statico per ottenere l'unica istanza di Logger
  public static Logger_singleton getInstance() {

    // Se l'istanza non esiste, viene creata
    if (instance == null) {
      instance = new Logger_singleton();
    }

    // Restituisce l'istanza esistente
    return instance;
  }

  // Metodo per stampare un messaggio di log
  public void log(String msg) {
    String dataOra = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    System.out.println("[LOG] " + "[" + dataOra + "] " + msg);
  }
}
