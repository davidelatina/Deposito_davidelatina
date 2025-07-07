/*
Progetta un logger centralizzato che possa essere usato da qualsiasi parte del
programma per scrivere messaggi di log su console. Il logger deve essere implementato
seguendo il pattern Singleton.

Requisiti:

Crea una classe Logger con:
Un campo privato statico per contenere l’unica istanza (private static Logger
istanza)
Un costruttore privato
Un metodo statico pubblico GetIstanza() che restituisce sempre la stessa
istanza
Un metodo ScriviMessaggio(string messaggio) che stampa il messaggio con data e
ora

Nel Main:
Richiama Logger.GetIstanza() da almeno due punti distinti del codice
Usa ScriviMessaggio() per stampare messaggi diversi
Dimostra che si tratta sempre della stessa istanza (es. confrontando i
riferimenti)
*/
public class ESSingleton {
  public static void main(String[] args) {

    // Inizio programma
    Logger_singleton log1 = Logger_singleton.getInstance();
    log1.log("Inizio programma");

    // Fine programma
    Logger_singleton log2 = Logger_singleton.getInstance();
    log2.log("Fine programma");

    // Sono la stessa istanza
    if (log1.equals(log2)) {
      System.out.println("Conferma: logger1 e logger2 sono la stessa istanza.");
    } else {
      System.out.println("Errore: le istanze non coincidono.");
    }

  }
}
