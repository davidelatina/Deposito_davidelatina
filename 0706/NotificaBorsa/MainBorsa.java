/*
Esercizio Medio – Sistema di Notifica Borsa

Obiettivo: Modellare un sistema in cui un'agenzia borsistica notifica più investitori su variazioni del valore azionario.

Requisiti:
  Creare un'interfaccia Investitore con il metodo notifica(String azione, double valore).

Implementare la classe AgenziaBorsa con:

  una lista di investitori registrati;

  metodi aggiungiInvestitore, rimuoviInvestitore, notificaInvestitori;

  un metodo aggiornaValoreAzione(String nome, double valore) che notifica gli investitori.

  Implementare almeno due classi Investitore, es. InvestitorePrivato e InvestitoreBancario, che rispondono con messaggi personalizzati.
*/

public class MainBorsa {
  public static void main(String[] args) {
    AgenziaBorsa myABorsa = new AgenziaBorsa();

    InvestitorePrivato myIPrivato = new InvestitorePrivato("Pippo");
    InvestitoreBancario myIBancario = new InvestitoreBancario("Banca di Topolinia");

    RicevitoreNotifiche test = new RicevitoreNotifiche("test");
    test.notifica("test", 0.0);

    //ConcreteObserver test2 = new ConcreteObserver("test");
    //test2.notifica("test2", 100.0);

    myIPrivato.notifica("test", 0);

    myABorsa.aggiungiInvestitore(myIBancario);
    myABorsa.aggiungiInvestitore(myIPrivato);

    myABorsa.aggiornaValoreAzione("Rockerduck", 1000.0);
    myABorsa.aggiornaValoreAzione("Bassotti Enterprises", 23.0);

  }
 }

 