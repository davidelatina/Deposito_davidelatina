// Interfaccia Strategy
interface Operazione_strategy_abstract {
  int esegui(int a, int b);
}

// Strategie Concrete
class Addizione_strategy_concrete implements Operazione_strategy_abstract {
  public int esegui(int a, int b) {
    System.out.println("Addizione eseguita.");
    return a + b;
  }
}

class Moltiplicazione_strategy_concrete implements Operazione_strategy_abstract {
  public int esegui(int a, int b) {
    System.out.println("Moltiplicazione eseguita.");
    return a*b;
  }
}

// Context
class Calcolatore_context {
  private Operazione_strategy_abstract strategy;

  public void setStrategy(Operazione_strategy_abstract strategy) {
    this.strategy = strategy;
  }

  public int performTask(int a, int b) {
    return strategy.esegui(a, b);
  }
}