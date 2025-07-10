// Sottosistema
class Bios {
  void inizializza() {
    System.out.println("Inizializzazione");
  }
}

class HardDisk {
  void carica() {
    System.out.println("Caricamento");
  }
}

class SistemaOperativo {
  void avvia() {
    System.out.println("Sistema operativo avviato.");
  }
}

// Facade Singleton
class ComputerFacadeSingleton {

  // Singleton
  private static ComputerFacadeSingleton instance;

  private ComputerFacadeSingleton() {}

  public static ComputerFacadeSingleton getInstance() {
    if (instance == null) {
      return new ComputerFacadeSingleton();
    }
    return instance;
  }

  // Facade
  private Bios a = new Bios();
  private HardDisk b = new HardDisk();
  private SistemaOperativo c = new SistemaOperativo();

  public void accendiComputer() {
    a.inizializza();
    b.carica();
    c.avvia();
  }
}

