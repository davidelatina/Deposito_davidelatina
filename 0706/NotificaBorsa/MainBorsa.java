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

import java.util.ArrayList;
import java.util.List;

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

 // Interfaccia Observer
 interface Investitore_observer {
   void notifica(String azione, double valore);
 }

 // Interfaccia Subject
 interface Subject {
   void aggiungiInvestitore(RicevitoreNotifiche o);

   void rimuoviInvestitore(RicevitoreNotifiche o);

   void notificaInvestitori();
 }

 // Concrete Subject
 class AgenziaBorsa implements Subject {
   private List<RicevitoreNotifiche> investitori = new ArrayList<>();
   private String azione;
   private double valore;

   public void aggiornaValoreAzione(String azione, double valore) {
     this.azione = azione;
     this.valore = valore;
     notificaInvestitori();
   }

   public void aggiungiInvestitore(RicevitoreNotifiche o) {
     investitori.add(o);
   }

   public void rimuoviInvestitore(RicevitoreNotifiche o) {
    investitori.remove(o);
   }

   public void notificaInvestitori() {
     if (investitori.isEmpty()) {
       return;
     }
     for (RicevitoreNotifiche o : investitori) {
       o.notifica(this.azione, this.valore);
     }
   }
 }

 class RicevitoreNotifiche implements Investitore_observer {
   private String name;

   public RicevitoreNotifiche(String name) {
     this.name = name;
   }
    public void notifica(String azione, double valore) {
      Logger_singleton.getInstance().log(this.toString() + " " + this.name + " ha ricevuto aggiornamento: " + azione + " a € " + valore);
    }
 }


 class InvestitorePrivato extends RicevitoreNotifiche {

  public InvestitorePrivato(String name) {
    super(name);
  }

 }

 class InvestitoreBancario extends RicevitoreNotifiche {

  public InvestitoreBancario(String name) {
    super(name);
  }
 }