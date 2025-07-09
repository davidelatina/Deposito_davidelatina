// Interfaccia Strategy
interface Pagamento_strategy {
  void paga(double importo);
}

// Strategie Concrete, ciascuna un singleton
class CartaDiCredito_strategy implements Pagamento_strategy {
  private static CartaDiCredito_strategy instance;
  private CartaDiCredito_strategy() {}
  
  public static CartaDiCredito_strategy getInstance() {
    if (instance == null) {
      instance = new CartaDiCredito_strategy();
    }
    return instance;
  }
  
  public void paga(double importo) {
    System.out.println("Pagamento effettuato tramite carta di credito.");
    System.out.printf("\t-%.2f sul tuo conto.", importo);
  }
}

class PayPal_strategy implements Pagamento_strategy {
  private static PayPal_strategy instance;
  private PayPal_strategy() {}

  private static double commissioni = 1.01;

  public static PayPal_strategy getInstance() {
    if (instance == null) {
      instance = new PayPal_strategy();
    }
    return instance;
  }

  public void paga(double importo) {
    System.out.println("Pagamento effettuato tramite PayPal");
    importo *= commissioni;
    System.out.printf("\t-%.2f sul tuo conto. (%.0f%% commissione)", importo, (commissioni-1)*100);
  }
}

// Context
class Pagamento_context implements Observer {
  private Pagamento_strategy strategy;

  private void setStrategy(Pagamento_strategy strategy) {
    this.strategy = strategy;
  }

  public void performTask(double importo) {
    strategy.paga(importo);
  }

  @Override
  public void update(Pagamento_strategy strategy) {
    setStrategy(strategy);
  }
}