import java.util.ArrayList;
import java.util.List;

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
     Logger_singleton.getInstance().log(this.getClass().toString() + " " + this.name + " ha ricevuto aggiornamento: " + azione + " a € " + valore);
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