// Sottosistema
class Bios {
  void inizializza() {
    System.out.println("Inizializzazione");
  }
}

class HardDisk {
  void carica() {
    System.out.println("Caricamento da hard disk");
  }
}

class SSD {
  void carica() {
    System.out.println("Caricamento da SSD");
  }
}

class SistemaOperativo {
  void avvia() {
    System.out.println("Sistema operativo avviato.");
  }
}



class AccendiComputerSistemaA implements ComputerStrategy {
  // Singleton
  private static AccendiComputerSistemaA instance;

  private AccendiComputerSistemaA() {}

  public static AccendiComputerSistemaA getInstance() {
    if (instance == null) {
      return new AccendiComputerSistemaA();
    }
    return instance;
  }
  // Strategy

  private Bios a = new Bios();
  private HardDisk b = new HardDisk();
  private SistemaOperativo c = new SistemaOperativo();

  public void execute() {
    this.accendiComputer();
  }

  public void accendiComputer() {
    a.inizializza();
    b.carica();
    c.avvia();
  }
}

class AccendiComputerSistemaB implements ComputerStrategy {
  // Singleton
  private static AccendiComputerSistemaB instance;

  private AccendiComputerSistemaB() {}

  public static AccendiComputerSistemaB getInstance() {
    if (instance == null) {
      return new AccendiComputerSistemaB();
    }
    return instance;
  }

  // Strategy
  private Bios a = new Bios();
  private SSD b = new SSD();
  private SistemaOperativo c = new SistemaOperativo();

  public void execute() {
    this.accendiComputer();
  }

  public void accendiComputer() {
    a.inizializza();
    b.carica();
    c.avvia();
  }
}



// Facade Context Singleton
class ComputerFacadeSingleton {

  // Singleton
  private static ComputerFacadeSingleton instance;

  private ComputerFacadeSingleton() {}

  public static ComputerFacadeSingleton getInstance() {
    if (instance == null) {
      instance = new ComputerFacadeSingleton();
    }
    return instance;
  }

  // Context (statico perché singleton)
  private static ComputerStrategy strategy;

  public void setStrategy(ComputerStrategy strategyNew) {
    strategy = strategyNew;
  }
  
  
  public void accendiComputer() {
    strategy.execute();
  }
}

