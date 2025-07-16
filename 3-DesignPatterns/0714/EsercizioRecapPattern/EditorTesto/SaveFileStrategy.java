// Interfaccia Strategy
interface SaveFileStrategy {
  void save(MessaggioBase testo);
}



// Strategie Concrete, ciascuna un singleton
class LocalStrategy implements SaveFileStrategy {
  private static LocalStrategy instance;
  private LocalStrategy() {}
  
  public static LocalStrategy getInstance() {
    if (instance == null) {
      instance = new LocalStrategy();
    }
    return instance;
  }
  
  public void save(MessaggioBase testo) {
    System.out.println("");
  }
}

class CloudStrategy implements SaveFileStrategy {
  private static CloudStrategy instance;
  private CloudStrategy() {}

  private static double commissioni = 1.01;

  public static CloudStrategy getInstance() {
    if (instance == null) {
      instance = new CloudStrategy();
    }
    return instance;
  }

  public void save(MessaggioBase testo) {
    System.out.println("Pagamento effettuato tramite PayPal");
    importo *= commissioni;
    System.out.printf("\t-%.2f sul tuo conto. (%.0f%% commissione)", importo, (commissioni-1)*100);
  }
}

// Context
class SaveFileContext implements Observer {
  private SaveFileStrategy strategy;

  private void setStrategy(SaveFileStrategy strategy) {
    this.strategy = strategy;
  }

  public void performTask(MessaggioBase testo) {
    strategy.save(MessaggioBase testo);
  }

  @Override
  public void update(SaveFileStrategy strategy) {
    setStrategy(strategy);
  }
}